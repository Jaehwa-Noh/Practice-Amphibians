package com.example.myapplication.di

import com.example.myapplication.data.AmphibiansInfoRepository
import com.example.myapplication.data.NetworkAmphibiansInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindNetworkAmphibiansInfoRepository(
        impl: NetworkAmphibiansInfoRepository
    ): AmphibiansInfoRepository
}

