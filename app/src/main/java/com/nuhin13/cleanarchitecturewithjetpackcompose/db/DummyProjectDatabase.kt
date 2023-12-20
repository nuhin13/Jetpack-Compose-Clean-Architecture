package com.nuhin13.cleanarchitecturewithjetpackcompose.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserInfo::class], version = 1
)
abstract class DummyProjectDatabase : RoomDatabase() {
    abstract val userInfoDao: UserInfoDao

}