package com.tugasakhir.pariwisata.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tugasakhir.pariwisata.R;
import com.tugasakhir.pariwisata.model.database.PrefManager;

public class SplashActivity extends AppCompatActivity {

    private static int splashInterval = 500;

    private PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        prefManager = new PrefManager(this);
        splash();
    }

    public void splash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (prefManager.isFirstTimeLaunch()){
                    Intent i = new Intent(SplashActivity.this, IntroActivity.class);
                    startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent
                }else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent
                }
                //jeda selesai Splashscreen
                this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);
    }

}
