package com.akatastroph.dlclaiterie;

import android.app.Application;

import com.akatastroph.dlclaiterie.di.AkatastrophComponent;
import com.akatastroph.dlclaiterie.di.DaggerAkatastrophComponent;
import com.akatastroph.dlclaiterie.di.module.AppModule;
import com.akatastroph.dlclaiterie.di.module.NetModule;

/**
 * Created by Genfinternet on 20/11/2016.
 */

public class AkatastrophApplication extends Application {
    private AkatastrophComponent mAkatastrophComponent;
    private static AkatastrophApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mAkatastrophComponent = DaggerAkatastrophComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public AkatastrophComponent getAkatastrophComponent() {
        return mAkatastrophComponent;
    }

    public static AkatastrophApplication getInstance() {
        return sInstance;
    }
}
