package com.nuhin13.cleanarchitecturewithjetpackcompose.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class UserInfo(
    @field:ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @field:ColumnInfo(name = "phoneNumber") val phoneNumber: String,
    @field:ColumnInfo(name = "pin") val pin: String,
    @field:ColumnInfo(name = "email") val email: String?
)