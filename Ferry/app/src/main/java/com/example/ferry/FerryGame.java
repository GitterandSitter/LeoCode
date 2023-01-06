package com.example.ferry;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.core.content.res.TypedArrayUtils;

import java.io.IOException;
import java.util.Random;

public class FerryGame extends SurfaceView implements Runnable {

    // Up to 3 islands
    private Island[] islands = new Island[3];
    private int islandCount = islands.length;
    private int mSpawnRate = 1;
    private Random randomX = new Random();
    private Random randomY = new Random();

    // Are we currently debugging
    //boolean mDebugging = true;
    // Objects for the game loop/thread
    private Thread gameThread = null;
    private volatile boolean playing;
    private boolean paused = true;

    // Objects for drawing
    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;
    // Keep track of the frame rate
    private long fps;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;
    // Holds the resolution of the screen
    private int screenX;
    private int screenY;
    // How big will the text be?
    private int fontSize;
    private int fontMargin;
    // These are for the sound
    private SoundPool soundpool;
    private int bellID = -1;
    private int hornID = -1;

    private Ship ferry;
    private boolean didVisit = false;
    private int numVisits;
    private int islandsToVisit = 10;

    // Let's time the game
    private long gameStartTime;
    private long bestGameTime;
    private long totalGameTime;


    // This is the constructor method that gets called
    // from GameActivity
    public FerryGame(Context context, int x, int y) {
        super(context);
        screenX = x;
        screenY = y;
        // Font is 5% of screen width
        fontSize = screenX / 20;
        // Margin is 2% of screen width
        fontMargin = screenX / 50;
        holder = getHolder();
        paint = new Paint();
        // Initialize the SoundPool
        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes =
                    new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA).setContentType
                            (AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build();
            soundpool = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundpool = new SoundPool(5, AudioManager.STREAM_MUSIC,
                    0);
        }
        try{
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;
            descriptor = assetManager.openFd("horn.mp3");
            hornID = soundpool.load(descriptor, 0);
            descriptor = assetManager.openFd("bell.mp3");
            bellID = soundpool.load(descriptor, 0);
        }catch(IOException e){
            Log.e("error", "failed to load sound files");
        }
/*
        for(int i = 0; i < islands.length; i++){
            islands[i] = new Island(this, screenX, spawnX);
        }*/

        ferry = new Ship(context, screenX, screenY);
        startGame();
    }

    // Called to start a new game
    public void startGame(){
        numVisits = 0;
        islandCount = 0;
        didVisit = false;
        // Did the player survive longer than previously
        if(totalGameTime > bestGameTime){
            bestGameTime = totalGameTime;
        }
        spawnIsland();


    }
    // Spawns another island bullet
    private void spawnIsland(){

        // Where to spawn the next island
        // And in which direction should it travel
        int spawnX;
        int spawnY;
        //int velocityX;
        int velocityY = 20; //Fixed "drop down" speed

        spawnX = randomX.nextInt
                (screenX);
        spawnY = screenY + randomY.nextInt //Spawn an island at the top, with 20 pixel margin
                (20);

        //Spawn an island at the correct yLevel

        /*// This code will change in chapter 13
        // Don't spawn to close to Bob
        if (mBob.getRect().centerX()
                < mScreenX / 2) {

            // Bob is on the left
            // Spawn bullet on the right
            spawnX = mRandomX.nextInt
                    (mScreenX / 2) + mScreenX / 2;
            // Head right
            velocityX = 1;
        } else {

            // Bob is on the right
            // Spawn bullet on the left
            spawnX = mRandomX.nextInt
                    (mScreenX / 2);
            // Head left
            velocityX = -1;
        }
        // Don't spawn to close to Bob
        if (mBob.getRect().centerY()
                < mScreenY / 2) {

            // Bob is on the top
            // Spawn bullet on the bottom
            spawnY = mRandomY.nextInt
                    (mScreenY / 2) + mScreenY / 2;
            // Head down
            velocityY = 1;
        } else {

            // Bob is on the bottom
            // Spawn bullet on the top
            spawnY = mRandomY.nextInt
                    (mScreenY / 2);
            // head up
            velocityY = -1;
        }*/
        // Pick a random point on the screen
        // to spawn a bullet  -  Redundant?
       /* spawnX = randomX.nextInt(screenX);
        spawnY = randomY.nextInt(mScreenY);*/

        /*// The horizontal direction of travel
        //velocityX = 1;
        // Randomly make velocityX negative
        if(mRandomX.nextInt(2)==0){
            velocityX = -1;
        }
        velocityY = 1;
        // Randomly make velocityY negative
        if(mRandomY.nextInt(2)==0){
            velocityY = -1;
        }*/

        // Spawn the island
        for(int i = 0; i < islandCount; i++){
            islands[i] = new Island(this, screenX, spawnX, velocityY);
        }


    }

    // Handles the game loop
    @Override
    public void run() {
        while (playing) {
            long frameStartTime = System.currentTimeMillis();
            if(!paused){
                update();
                // Now all the islands have been moved
                // we can detect any collisions
                detectCollisions();
            }
            draw();
            long timeThisFrame = System.currentTimeMillis()
                    - frameStartTime;
            if (timeThisFrame >= 1) {
                fps = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }
    // Update all the game objects
    private void update(){ for(int i = 0; i < islandCount; i++){
        islands[i].update(fps);
    }
    }
    private void detectCollisions(){
        // Has a bullet collided with a wall?
        // Loop through each active bullet in turn
        for(int i = 0; i < islandCount; i++) {
            if (islands[i].getRect().bottom > screenY) {
                playing = false;
                paused = true;
            }

        }

        // Has an island been visited?
        // Check each island for an intersection with Ship's RectF
        for (int i = 0; i < islandCount; i++) {
            if (RectF.intersects(islands[i].getRect(),
                    ferry.getRect())) {
                // Island has been visited
                soundpool.play(bellID, 1, 1, 0, 0, 1);
                // This flags that a hit occurred
                // so that the draw
                // method "knows" as well
                didVisit = true;
                // Rebound the bullet that collided
                /*mBullets[i].reverseXVelocity();
                mBullets[i].reverseYVelocity();*/
                // keep track of the number of hits
                numVisits++;
                if(numVisits == islandsToVisit) {
                    paused = true;
                    totalGameTime = System.currentTimeMillis()
                            - gameStartTime;
                    startGame();
                }
            }
        }
    }


    private void draw(){
        if (holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();
            canvas.drawColor(Color.argb(255, 160, 209, 242)); //Background color blue
            paint.setColor(Color.argb(255, 255, 255, 255));

            // All the drawing code will go here
            for(Island island : islands){
                canvas.drawBitmap(island.getBitmap(),
                        island.getRect().left, island.getRect().top,
                        paint);
            }

            canvas.drawBitmap(ferry.getBitmap(),
                    ferry.getRect().left, ferry.getRect().top,
                    paint);
            paint.setTextSize(fontSize);
            canvas.drawText("Islands: " + islandCount +
                            " Islands to visit: " + (islandsToVisit - numVisits) +
                            " Best Time: " + bestGameTime /
                            MILLIS_IN_SECOND,
                    fontMargin, fontSize, paint);
            // Don't draw the current time when paused
            if(!paused) {
                canvas.drawText("Seconds Sailed: " +
                                ((System.currentTimeMillis() -
                                        gameStartTime) / MILLIS_IN_SECOND),
                        fontMargin, fontMargin * 30,
                        paint);
            }


            /*if(mDebugging) {
                printDebuggingText();
            }*/
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        switch (motionEvent.getAction() &
                MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                if(paused){
                    gameStartTime =
                            System.currentTimeMillis();
                    paused = false;
                }
                ferry.steer(motionEvent.getX(), motionEvent.getY());
                    //soundpool.play(mTeleportID, 1, 1, 0, 0, 1);

                break;
            case MotionEvent.ACTION_UP:
                ferry.setSteering();

                break;
        }
        return true;

    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }
    }
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    /*private void printDebuggingText(){
        int debugSize = 35;
        int debugStart = 150;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS ,
                10, debugStart + debugSize, mPaint);
        mCanvas.drawText("Bob left: " + mBob.getRect().left ,
                10, debugStart + debugSize *2, mPaint);
        mCanvas.drawText("Bob top: " + mBob.getRect().top ,
                10, debugStart + debugSize *3, mPaint);
        mCanvas.drawText("Bob right: " + mBob.getRect().right ,
                10, debugStart + debugSize *4, mPaint);
        mCanvas.drawText("Bob bottom: " +
                        mBob.getRect().bottom ,
                10,debugStart + debugSize *5, mPaint);
        mCanvas.drawText("Bob centerX: " +
                        mBob.getRect().centerX() ,
                10,debugStart + debugSize *6, mPaint);
        mCanvas.drawText("Bob centerY: " +
                        mBob.getRect().centerY() ,
                10, debugStart + debugSize *7, mPaint);
    }*/

}




