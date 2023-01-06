package com.example.ferry;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class Ship {
    RectF shipRectangle;
    float shipHeight;
    float shipWidth;
    boolean steering = false;
    Bitmap shipBitmap;

    public Ship(Context context, float screenX, float screenY){
        shipHeight = screenY / 10;
        shipWidth = shipHeight / 2;
        //Set the ship in the middle of the screen, at the bottom
        shipRectangle = new RectF(screenX / 2,screenY,
                (screenX / 2) + shipWidth,
                (screenY) + shipHeight);
        // Prepare the bitmap
        // Load Ship from it's .png file
        shipBitmap = BitmapFactory.decodeResource
                (context.getResources(), R.drawable.bluestar);
        shipBitmap = Bitmap
                .createScaledBitmap(shipBitmap, 300, 400, false);
    }

    boolean steer(float newX, float newY){
        // Did ship manage to steer?
        boolean success = false;
        // Move ship to the new position
        // If not already steering
        if(!steering){
            // Make it roughly central to the touch- and the assigned y-level
            shipRectangle.left = newX - shipWidth / 2;
            shipRectangle.top = newY- shipHeight / 2;   //Place center of the bitMap Rectangle at the received y-coordinate.
            shipRectangle.bottom = shipRectangle.top + shipHeight;
            shipRectangle.right = shipRectangle.left + shipWidth;
            steering = true;
            // Notify FerryGame that steer
            // attempt was successful
            success = true;
        }
        return success;
    }

    void setSteering(){
        steering = false;
    }
    // Return a reference to mRect
    RectF getRect(){
        return shipRectangle;
    }
    // Return a reference to bitmap
    Bitmap getBitmap(){
        return shipBitmap;
    }
}
