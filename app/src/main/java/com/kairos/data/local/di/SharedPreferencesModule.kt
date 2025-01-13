package com.kairos.data.local.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {}

 /*   @Provides
    @Singleton
    fun ProvideSharedPreferenceModule() {


    }


}*/