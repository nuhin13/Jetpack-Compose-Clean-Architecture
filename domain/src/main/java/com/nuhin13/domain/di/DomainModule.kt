package com.nuhin13.domain.di

import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import com.nuhin13.domain.feature.authentication.repository.AuthenticationUseCase
import com.nuhin13.domain.feature.authentication.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Reusable
    fun provideLoginUseCase(authenticationRepository: AuthenticationRepository): AuthenticationUseCase {
        return LoginUseCase(authenticationRepository)
    }
}