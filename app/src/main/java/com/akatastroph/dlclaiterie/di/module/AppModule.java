package com.akatastroph.dlclaiterie.di.module;

import android.app.Application;
import android.content.Context;

import com.akatastroph.dlclaiterie.AkatastrophApplication;
import com.akatastroph.dlclaiterie.utils.UserPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Genfinternet on 20/11/2016.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(AkatastrophApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    UserPreferences provideUserPreference() {
        return new UserPreferences(mApplication);
    }
}
