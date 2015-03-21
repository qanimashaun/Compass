/*
*
*
*/
package com.qudusanimashaun.testsensormanager;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import static java.lang.Math.*;


public class MainActivity extends ActionBarActivity {
    private static SensorManager sensorService;
    private Sensor sensor;
    private Button mButton;
    private Location mLocation;
    private double gAzimuth;
    private Circle mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor != null) {
            sensorService.registerListener(mySensorEventListener, sensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
            Log.i("Compass MainActivity", "Registerered for ORIENTATION Sensor");
        } else {
            Log.e("Compass MainActivity", "Registerered for ORIENTATION Sensor");
            Toast.makeText(this, "ORIENTATION Sensor not found",
                    Toast.LENGTH_LONG).show();
            finish();
        }
        mLocation = new Location(10.0,20.0);
        mCircle = new Circle(new Point(10,20), gAzimuth, new Point(10,10));
        mButton = (Button) findViewById(R.id.stepButton);


        mButton.setOnClickListener(new View.OnClickListener() {
            double mOldAngle =0.0;

            @Override
            public void onClick(View v) {
//                if (gAzimuth<90){
//                    mLocation.moveNorthEast(gAzimuth);
//                }else if(gAzimuth>=90 && gAzimuth<180 ){
//                    mLocation.moveSouthEast(gAzimuth);
//                }else if(gAzimuth>=180 &&gAzimuth<270){
//                    mLocation.moveSouthWest(gAzimuth);
//                }else{
//                    mLocation.moveNorthWest(gAzimuth);
//                }



                mCircle.calculatePositionAim(abs(mOldAngle - gAzimuth));
                mOldAngle = gAzimuth;

            }
        });
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // angle between the magnetic north direction
            // 0=North, 90=East, 180=South, 270=West
            float azimuth = event.values[0];
            gAzimuth=(int)azimuth;
            Log.d("Compass MainActivity", gAzimuth +"");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensor != null) {
            sensorService.unregisterListener(mySensorEventListener);
        }
    }




}
