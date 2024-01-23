package com.nuhin13.data.di

import com.nuhin13.data.features.authentication.AuthRepoImpl
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Reusable
    fun provideAuthRepo(): AuthenticationRepository {
        return AuthRepoImpl()
    }
}