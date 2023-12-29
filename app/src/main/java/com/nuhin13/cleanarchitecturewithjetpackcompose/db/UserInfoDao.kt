package com.nuhin13.cleanarchitecturewithjetpackcompose.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInfoDao {
    @Insert
    suspend fun insert(entity: UserInfo)

    @Insert
    suspend fun insert(entities: List<UserInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: UserInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entities: List<UserInfo>)

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