package com.example.yura.orientation2;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

        private Button mButton;
        static final String ORIENTATION_PORTRAIT = "Портретный режим";
        static final String ORIENTATION_LANDSCAPE = "Альбомный режим";

        // определяем изменение ориентации экрана
        boolean mState = false;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mButton = (Button) findViewById(R.id.button);

            // установим текст по умолчанию
            mButton.setText("Кнопка");
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            // Проверяем ориентацию экрана
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Toast.makeText(this, ORIENTATION_LANDSCAPE, Toast.LENGTH_SHORT).show();
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Toast.makeText(this, ORIENTATION_PORTRAIT, Toast.LENGTH_SHORT).show();
            }
        }


        public void onClick(View view) {
            // state FALSE: переключаемся на LANDSCAPE
            if (!mState) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                //mButton.setText(ORIENTATION_PORTRAIT);
            }
            // state TRUE: переключаемся на PORTRAIT
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                //mButton.setText(ORIENTATION_LANDSCAPE);
            }
            // обновляем state на противоположное значение
            mState = !mState;
        }
    }

