package com.anushka.hiltdemo0.hilt

import com.anushka.hiltdemo0.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {
    @Provides
    fun providesDataSource(): DataSource {
        return DataSource()
    }

}