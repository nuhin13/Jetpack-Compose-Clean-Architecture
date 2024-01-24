package com.nuhin13.data.features.authentication.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nuhin13.data.features.authentication.db.table.UserInfoTable

@Dao
interface UserInfoDao {
    @Insert
    suspend fun insert(entity: UserInfoTable)

    @Query("SELECT * FROM user_info11")
    suspend fun fetchAll(): List<UserInfoTable>

    @Query("SELECT * FROM user_info11 WHERE id = :id")
    suspend fun fetchById(id: Long): UserInfoTable

    @Query("SELECT * FROM user_info11 WHERE phoneNumber = :phone")
    suspend fun fetchByPhone(phone: String): UserInfoTable?

    @Query("DELETE FROM user_info11")
    suspend fun deleteAll()

    @Query("DELETE FROM user_info11 WHERE id = :id")
    suspend fun deleteById(id: Int)
}