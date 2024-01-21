package com.nuhin13.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nuhin13.data.db.table.UserInfo

@Dao
interface UserInfoDao {
    @Insert
    suspend fun insert(entity: UserInfo)

    @Query("SELECT * FROM user_info")
    suspend fun fetchAll(): List<UserInfo>

    @Query("SELECT * FROM user_info WHERE id = :id")
    suspend fun fetchById(id: Long): UserInfo

    @Query("SELECT * FROM user_info WHERE phoneNumber = :phone")
    suspend fun fetchByPhone(phone: String): UserInfo?

    @Query("DELETE FROM user_info")
    suspend fun deleteAll()

    @Query("DELETE FROM user_info WHERE id = :id")
    suspend fun deleteById(id: Int)
}