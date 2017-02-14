package org.ivandgetic.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.ivandgetic.AppConfig;
import org.ivandgetic.cube.R;
import org.ivandgetic.view.MyGLSurfaceView;

import java.util.Timer;
import java.util.TimerTask;


public class KubeActivity extends Activity {

    Timer timer = new Timer();
    int timeshow = 0;
    private MyGLSurfaceView mGLSurfaceView;
    private Switch showCoordinateSystem;
    private TextView timeTV;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            timeshow++;
            timeTV.post(new Runnable() {
                @Override
                public void run() {
                    timeTV.setText(timeshow + " SECOND");
                }
            });
        }
    };
    private Button daluan;
    private Button numberPickerButton;
    private AdView mAdView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kube);
        mAdView = (AdView)findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        mGLSurfaceView = (MyGLSurfaceView) findViewById(R.id.myGLSurfaceView);
        daluan = (Button) findViewById(R.id.daluan);
        showCoordinateSystem = (Switch) findViewById(R.id.showCoordinateSystem);
        showCoordinateSystem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppConfig.showCoordinateSystem = true;
                } else {
                    AppConfig.showCoordinateSystem = false;
                }
            }
        });
        timeTV = (TextView) findViewById(R.id.timeTV);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }


    public void startGame(View view) {
        AppConfig.daluan=true;
        timer.schedule(timerTask, 1000, 1000);
        daluan.setEnabled(false);
    }
}