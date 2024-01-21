package com.nuhin13.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nuhin13.data.db.dao.UserInfoDao
import com.nuhin13.data.db.table.UserInfo

@Database(
    entities = [UserInfo::class], version = 1
)
abstract class DummyProjectDatabase : RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
}