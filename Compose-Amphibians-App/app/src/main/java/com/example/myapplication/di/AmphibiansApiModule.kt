package com.example.myapplication.di

import com.example.myapplication.data.AmphibiansApi
import com.example.myapplication.network.AmphibiansKtorApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AmphibiansApiModule {

    @Binds
    @Singleton
    abstract fun bindKtorAmphibiansApi(impl: AmphibiansKtorApiService): AmphibiansApi
}


