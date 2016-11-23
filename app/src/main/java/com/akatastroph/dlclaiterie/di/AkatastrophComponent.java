package com.akatastroph.dlclaiterie.di;

import com.akatastroph.dlclaiterie.activity.SplashScreenActivity;
import com.akatastroph.dlclaiterie.di.module.AppModule;
import com.akatastroph.dlclaiterie.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Genfinternet on 20/11/2016.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AkatastrophComponent {
    void inject(SplashScreenActivity activity);
}
