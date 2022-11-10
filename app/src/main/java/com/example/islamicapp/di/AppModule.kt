package com.example.islamicapp.di

import android.content.Context
import com.example.islamicapp.location.GetLocation
import com.example.islamicapp.utils.PermissionUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideString(): String {
        return "string returned from hilt method"
    }

    @Singleton
    @Provides
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun providesLocationObject(@ApplicationContext context: Context): GetLocation {
        return GetLocation(context)
    }

    @Singleton
    @Provides
    fun providesPermissionUtils(@ApplicationContext context: Context): PermissionUtils {
        return PermissionUtils(context)
    }
}
