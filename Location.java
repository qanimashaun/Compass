package com.qudusanimashaun.testsensormanager;

import android.util.Log;

import static java.lang.Math.*;

/**
 * Created by qudusanimashaun on 21/03/15.
 */
public class Location {
    private final double mLocationX =  20.0;
    private final double mLocationY = 20.0;
    private double mCurrentLocationX;
    private double mCurrentLocationY;

    public Location(double startX, double startY ){
        mCurrentLocationX = startX;
        mCurrentLocationY = startY;

    }

    public void moveNorthWest(int degrees){
        int degree = 360 -degrees;
        double movedAmountY = cos((double) degree);
        double  movedAmountX = sin((double) degree);
        if(mCurrentLocationX-movedAmountX >0 &&
                mCurrentLocationX-movedAmountX<20 &&
                mCurrentLocationY-movedAmountY<20 &&
                mCurrentLocationY-movedAmountY>0) {
            mCurrentLocationX = mCurrentLocationX - movedAmountX;
            mCurrentLocationY = mCurrentLocationY - movedAmountY;
            Log.i("moving NorthWest", "Your Current Location is " + String.format("%.2f", mCurrentLocationX) + " , " + String.format("%.2f", mCurrentLocationY));
        }else{
            Log.e("error", "You cannot move there");
        }
    }

    public void moveNorthEast(int degrees){
        int degree = degrees;
        double movedAmountY = cos((double) degree);
        double  movedAmountX = sin((double) degree);
        if(mCurrentLocationX+movedAmountX >0 &&
                mCurrentLocationX+movedAmountX<20 &&
                mCurrentLocationY-movedAmountY<20 &&
                mCurrentLocationY-movedAmountY>0) {
        mCurrentLocationX=mCurrentLocationX+movedAmountX;
        mCurrentLocationY=mCurrentLocationY-movedAmountY;
        Log.i("moving North East", "Your Current Location is "+ String.format("%.2f", mCurrentLocationX)+" , "+ String.format("%.2f", mCurrentLocationY));

        }else{
            Log.e("error", "You cannot move there");
        }
    }

    public void moveSouthWest(int degrees){
        int degree = degrees-180;
        double movedAmountY = cos((double) degree);
        double  movedAmountX = sin((double) degree);
        if(mCurrentLocationX-movedAmountX >0 &&
                mCurrentLocationX-movedAmountX<20 &&
                mCurrentLocationY+movedAmountY<20 &&
                mCurrentLocationY+movedAmountY>0) {
        mCurrentLocationX=mCurrentLocationX-movedAmountX;
        mCurrentLocationY=mCurrentLocationY+movedAmountY;
        Log.i("moving South West", "Your Current Location is "+ String.format("%.2f", mCurrentLocationX)+" , "+ String.format("%.2f", mCurrentLocationY));
        }else{
            Log.e("error", "You cannot move there");
        }
    }

    public void moveSouthEast(int degrees){
        int degree = 180 -degrees;
        double movedAmountY = cos((double) degree);
        double  movedAmountX = sin((double) degree);if(mCurrentLocationX+movedAmountX >0 &&
                mCurrentLocationX+movedAmountX<20 &&
                mCurrentLocationY+movedAmountY<20 &&
                mCurrentLocationY+movedAmountY>0) {
        mCurrentLocationX=mCurrentLocationX+movedAmountX;
        mCurrentLocationY=mCurrentLocationY+movedAmountY;
        Log.i("movementing South East", "Your Current Location is "+ String.format("%.2f", mCurrentLocationX)+" , "+ String.format("%.2f", mCurrentLocationY));
        }else{
            Log.e("error", "You cannot move there");
        }
    }

}
