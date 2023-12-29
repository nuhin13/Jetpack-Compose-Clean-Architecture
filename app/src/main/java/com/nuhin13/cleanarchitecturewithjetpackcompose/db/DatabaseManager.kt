package com.nuhin13.cleanarchitecturewithjetpackcompose.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

object DatabaseManager {
    private var instance: DummyProjectDatabase? = null

    fun getInstance(context: Context): DummyProjectDatabase {
        if (instance == null) {
            synchronized(this) {
                instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        DummyProjectDatabase::class.java,
                        "DUMMY_DATABASE"
                    ).build()
            }
        }
        return instance!!
    }
}

/*
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DummyProjectDatabase {
        return Room.databaseBuilder(context, DummyProjectDatabase::class.java, "DUMMY_DATABASE")
            .build()
    }
}*/
