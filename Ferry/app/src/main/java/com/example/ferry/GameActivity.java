package com.example.ferry;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends Activity {

    // An instance of the main class of this project
    private FerryGame ferryGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Get the screen resolution
        Display display = getWindowManager()
                .getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        // Call the constructor(initialize)
        // the BulletHellGame instance
        ferryGame = new FerryGame(this, size.x, size.y);
        setContentView(ferryGame);
    }
    @Override
    // Start the main game thread
    // when the game is launched
    protected void onResume() {
        super.onResume();
        ferryGame.resume();
    }
    @Override
    // Stop the thread when the player quits
    protected void onPause() {
        super.onPause();
        ferryGame.pause();
    }

}
