package org.ivandgetic.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.ivandgetic.AppConfig;
import org.ivandgetic.cube.R;

/**
 * Created by ivandgetic on 2015/6/12 0012.
 */
public class MainActivity extends Activity {
    Switch bgMusic;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = (AdView)findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        bgMusic = (Switch) findViewById(R.id.backgroundMusic);
        bgMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppConfig.playSound = true;
                } else {
                    AppConfig.playSound = false;
                }
            }
        });
    }

    public void enterGame(View view) {
        startActivity(new Intent(this, KubeActivity.class));
        AppConfig.daluan=false;
    }

    public void gameHelp(View view) {
        Intent intent = new Intent(MainActivity.this,InterestialLogout.class);
        startActivity(intent);
    }
}
