package com.akatastroph.dlclaiterie.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.akatastroph.dlclaiterie.AkatastrophApplication;
import com.akatastroph.dlclaiterie.R;
import com.akatastroph.dlclaiterie.utils.UserPreferences;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashScreenActivity extends BaseActivity {
    @Inject UserPreferences mUserPreferences;
    @BindView(R.id.logo) View logo;
    @BindView(R.id.company_name) View name;
    private Animation mGrowth;
    private Animation mSlideUpAndFadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AkatastrophApplication.getInstance().getAkatastrophComponent().inject(this);
        init();
    }

    public void init() {
        initActionBar();
        initAnimation();
    }

    public void initActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(R.color.white));
        }
    }

    public void initAnimation () {
        mGrowth = AnimationUtils.loadAnimation(this, R.anim.growth);
        mSlideUpAndFadeIn = AnimationUtils.loadAnimation(this, R.anim.slide_up_and_fade_in);
        mGrowth.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startNextActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @OnClick(R.id.reset)
    public void reset() {
        logo.startAnimation(mGrowth);
        name.startAnimation(mSlideUpAndFadeIn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        reset();
    }

    private void startNextActivity() {
        if (mUserPreferences.isFirstStart()) {
            Toast.makeText(this, "First Start", Toast.LENGTH_SHORT).show();
            mUserPreferences.completeFirstStart();
        } else {
            Toast.makeText(this, "Not First Start", Toast.LENGTH_SHORT).show();
        }
    }
}
