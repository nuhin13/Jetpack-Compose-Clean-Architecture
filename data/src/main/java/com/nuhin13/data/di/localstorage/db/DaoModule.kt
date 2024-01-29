package com.nuhin13.data.di.localstorage.db

import com.nuhin13.data.features.authentication.datasource.AuthenticationDataSource
import com.nuhin13.data.features.authentication.datasource.AuthenticationLocalSourceImpl
import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    @Singleton
    fun provideAuthDataSource(userInfoDao: UserInfoDao): AuthenticationDataSource {
        return AuthenticationLocalSourceImpl(userInfoDao)
    }
}