package com.barclays.stockmarketwatch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    public static final int ANIMATING_TIME = 500;

    @BindView(R.id.logo_img)
    ImageView bgLogo;

    @BindView(R.id.version)
    TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        tvVersion.setText("Version: "+ AppConfig.getAppVersion());
        startAnimation();
    }

    private void startAnimation() {

        final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoom);
        bgLogo.startAnimation(zoomAnimation);
        zoomAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Handler mHandler = new Handler(getMainLooper());
                Runnable mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        startFunctions();
                    }
                };
                mHandler.postDelayed(mRunnable, ANIMATING_TIME);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void startFunctions() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}