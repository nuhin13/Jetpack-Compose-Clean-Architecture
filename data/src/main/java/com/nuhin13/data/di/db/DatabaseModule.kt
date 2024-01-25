package com.nuhin13.data.di.db

import android.content.Context
import androidx.room.Room
import com.nuhin13.data.db.DummyProjectDatabase
import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): DummyProjectDatabase {
        return Room.databaseBuilder(
            appContext,
            DummyProjectDatabase::class.java,
            "Dummy_Database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(appDatabase: DummyProjectDatabase): UserInfoDao {
        return appDatabase.userInfoDao()
    }
}