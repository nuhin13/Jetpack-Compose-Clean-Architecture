package com.nuhin13.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import com.nuhin13.data.features.authentication.db.table.UserInfoTable

@Database(
    entities = [UserInfoTable::class], version = 12
)
abstract class DummyProjectDatabase : RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
}