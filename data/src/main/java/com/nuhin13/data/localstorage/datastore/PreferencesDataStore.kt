package com.nuhin13.data.localstorage.datastore

import androidx.datastore.preferences.core.Preferences

interface PreferencesDataStore {
    suspend fun saveJson(key: Preferences.Key<String>, json: String)
    suspend fun getJson(key: Preferences.Key<String>): String
    suspend fun saveString(key: Preferences.Key<String>, value: String)
    suspend fun getString(key: Preferences.Key<String>): String
    suspend fun saveBoolean(key: Preferences.Key<String>, value: Boolean)
    suspend fun getBoolean(key: Preferences.Key<String>): Boolean
    suspend fun saveInt(key: Preferences.Key<String>, value: Int)
    suspend fun getInt(key: Preferences.Key<String>): Int
}