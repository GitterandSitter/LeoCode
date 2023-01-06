package com.example.ferry;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class Island  {

    // A RectF to represent the size and location of the island
    private RectF islandRectangle;
    // How fast is the island moving downwards?
    //private float mXVelocity;
    private float yVelocity;
    // How big is an island
    private float islandWidth;
    private float islandHeight;
    private int spawnX;
    Bitmap islandBitmap;

    // The constructor
    public Island(FerryGame context, int screenX, int spawnX, float yVelocity){
        // Configure the island based on
        // the screen width in pixels- a tenth of the screen horizontal scale
        islandWidth = screenX / 10;
        islandHeight = screenX / 15;
        this.spawnX = spawnX;
        islandRectangle = new RectF();
        yVelocity = (screenX / 5);
        //mXVelocity = (screenX / 5);
        islandBitmap = BitmapFactory.decodeResource
                (context.getResources(), R.drawable.island);
        islandBitmap = Bitmap
                .createScaledBitmap(islandBitmap, 500, 500, false);
    }

    // Return a reference to the RectF
    RectF getRect(){
        return islandRectangle;
    }
    // Move the island based on the speed and the frame rate

    Bitmap getBitmap(){
        return islandBitmap;
    }

    void update(long fps){
// Update the left and top coordinates
// based on the velocity and current frame rate
        islandRectangle.left = spawnX;//+ (mXVelocity / fps);
        //+ replaced by - ?
        islandRectangle.top = islandRectangle.top - (yVelocity / fps);
        islandRectangle.right = islandRectangle.left + islandWidth;
        islandRectangle.bottom = islandRectangle.top - islandHeight;
    }

   /* // Spawn a new island
    void spawn(int pX, int pY, int vX, int vY){
        // Spawn the bullet at the location
        // passed in as parameters
        mRect.left = pX;
        mRect.top = pY;
        mRect.right = pX + mWidth;
        mRect.bottom = pY + mHeight;
        // Head away from the player
        // It's only fair
        mXVelocity = mXVelocity * vX;
        mYVelocity = mYVelocity * vY;
    }*/



}
