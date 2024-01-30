package com.nuhin13.data.localstorage.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PreferencesDataStoreImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferencesDataStore {
    override suspend fun saveJson(key: Preferences.Key<String>, json: String) {
        dataStore.edit { preferences ->
            preferences[key] = json
        }
    }

    override suspend fun getJson(key: Preferences.Key<String>): String {
        val preferences = dataStore.data.first()
        return preferences[key] ?: ""
    }

    override suspend fun saveString(key: Preferences.Key<String>, value: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getString(key: Preferences.Key<String>): String {
        TODO("Not yet implemented")
    }

    override suspend fun saveBoolean(key: Preferences.Key<String>, value: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun getBoolean(key: Preferences.Key<String>): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun saveInt(key: Preferences.Key<String>, value: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getInt(key: Preferences.Key<String>): Int {
        TODO("Not yet implemented")
    }

    override suspend fun saveArrayList(key: Preferences.Key<String>, list: ArrayList<*>) {
        TODO("Not yet implemented")
    }

    override suspend fun getArrayList(key: Preferences.Key<String>): ArrayList<*> {
        TODO("Not yet implemented")
    }
}