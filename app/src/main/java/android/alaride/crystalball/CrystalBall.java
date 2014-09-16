package android.alaride.crystalball;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class CrystalBall extends Activity {

    private TextView answerText;

        private SensorManager sensorManager;
        private Sensor accelerometer;
        private float acceleration;
        private float currentAcceleration;
        private float previousAcceleration;

        private final SensorEventListener sensorListener = new SensorEventListener(){

        @override
        public void onSensorChanged (SensorEvent event){

            float x = 
    }
        @override
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
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
