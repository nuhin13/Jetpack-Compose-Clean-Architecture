package com.nuhin13.cleanarchitecturewithjetpackcompose.di.db

import android.content.Context
import androidx.room.Room
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.DummyProjectDatabase
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.dao.UserInfoDao
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
    //@Named("Dummy_Database")
    fun provideAppDatabase(@ApplicationContext appContext: Context): DummyProjectDatabase {
       /* return Room.inMemoryDatabaseBuilder(appContext, DummyProjectDatabase::class.java)
            .allowMainThreadQueries().build()*/

        return Room.databaseBuilder(
            appContext,
            DummyProjectDatabase::class.java,
            "Dummy_Database"
        ).build()
    }
    @Provides
    @Singleton
    fun provideDao(appDatabase: DummyProjectDatabase) : UserInfoDao {
        return appDatabase.userInfoDao()
    }

//    @Provides
//    @Singleton
//    fun provideTaskRepository(taskDao: UserInfoDao): TaskRepository {
//        return TaskRepository(taskDao)
//    }
}