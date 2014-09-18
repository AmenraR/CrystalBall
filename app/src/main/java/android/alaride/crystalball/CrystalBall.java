package android.alaride.crystalball;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.widget.TextView;
import android.widget.Toast;


public class CrystalBall extends Activity {

    private TextView answerText;

        private SensorManager sensorManager;
        private Sensor accelerometer;
        private float acceleration;
        private float currentAcceleration;
        private float previousAcceleration;

        private final SensorEventListener sensorListener = new SensorEventListener(){

        @Override
        public void onSensorChanged (SensorEvent event){

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            previousAcceleration = currentAcceleration;
            currentAcceleration = FloatMath.sqrt(x * x + y * y + z * z);
            float delta = currentAcceleration - previousAcceleration;
            acceleration = acceleration * 0.9f + delta;

            if(acceleration > 18){
                Toast toast = Toast.makeText(getApplication() , "Device Has Shaken" , Toast.LENGTH_SHORT);
                toast.show();

            }
    }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crystal_ball);

        sensorManager = (SensorManager)getSystemService(Context.SEARCH_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        acceleration = 0.0f;
        currentAcceleration = SensorManager.GRAVITY_EARTH;
        previousAcceleration = SensorManager.GRAVITY_EARTH;

        answerText = (TextView)findViewById(R.id.answerText);
        answerText.setText(Predictions.get().getPrediction());

    }

    @Override
    protected void onResume() {

        super.onResume();

        sensorManager.registerListener(sensorListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorListener);
    }

}
