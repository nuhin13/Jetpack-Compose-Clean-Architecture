package com.nuhin13.data.localstorage.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

class PrefConstant {
    companion object {
        val USER_INFO = stringPreferencesKey("user_info")
        val POST_LIST = stringPreferencesKey("post_list")
    }
}