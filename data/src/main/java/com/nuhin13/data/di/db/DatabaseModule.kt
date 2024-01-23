package com.nuhin13.data.di.db

import android.content.Context
import androidx.room.Room
import com.nuhin13.data.db.DummyProjectDatabase
import com.nuhin13.data.db.dao.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    @Named("db1")
    fun provideAppDatabase(@ApplicationContext appContext: Context): DummyProjectDatabase {
        return Room.databaseBuilder(
            appContext,
            DummyProjectDatabase::class.java,
            "Dummy_Databaseqq"
        ).build()
    }

    @Provides
    @Singleton
    @Named("dao1")
    fun provideDao(appDatabase: DummyProjectDatabase): UserInfoDao {
        return appDatabase.userInfoDao()
    }

    /*@Provides
    @Singleton
    fun provideTaskRepository(taskDao: com.nuhin13.data.db.dao.UserInfoDao): TaskRepository {
        return TaskRepository(taskDao)
    }*/
}