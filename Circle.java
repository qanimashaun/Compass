package com.qudusanimashaun.testsensormanager;


import android.graphics.Point;
import android.util.Log;

import static java.lang.Math.*;

/**
 * Created by qudusanimashaun on 21/03/15.
 */
public class Circle {
    private Point mCenter;
    private Point mPositionAim;
    private double mAngle;

    public Circle(Point center, double angle, Point positionAim) {
        mCenter = center;
        mAngle= angle;
        mPositionAim = positionAim;
    }


    public Point calculatePositionAim(double newAngle){

        double theta = (newAngle*Math.PI)/180;

        double newX = mCenter.x + 10 * cos(theta);
        double newY = mCenter.y + 10 * sin(theta);

        mPositionAim.set((int)newX,(int) newY);

        mAngle = theta;

        Log.v("Theta : ", theta + "");
        Log.v("Coordinate : ", newX + ", " + newY);
        Log.v("Angle Difference", newAngle + "");


//        double theta =(mAngle +newAngle) ;
//
//        double u = (mPositionAim.x *cos(theta)) +( mPositionAim.y *sin(theta));
//        double v = (-mPositionAim.x *sin(theta)) + (mPositionAim.y *cos(theta));
//        mPositionAim.set((int)u,(int) v);
//        mAngle = theta;
       // Log.i("Position Variables", "The Position Aim coordinates are" + mPositionAim.x + " , " +mPositionAim.y + "theta is "+ theta);

        return mPositionAim;
    }



}
