package com.chanhypark.baseapparchitecture.app

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder


class SharedPreference(context: Context) {

    private val sharedPref = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
    private val gson = GsonBuilder().create()

    fun save(KEY_NAME: String, text: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putString(KEY_NAME, text)

        editor.commit()
    }

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putInt(KEY_NAME, value)

        editor.commit()
    }

    fun save(KEY_NAME: String, value: Long) {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putLong(KEY_NAME, value)

        editor.commit()
    }

    fun save(KEY_NAME: String, status: Boolean) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putBoolean(KEY_NAME, status)

        editor.commit()
    }

    fun getValueString(KEY_NAME: String): String? {

        return sharedPref.getString(KEY_NAME, null)

    }

    fun getValueInt(KEY_NAME: String)= sharedPref.getInt(KEY_NAME, 0)

    fun getValueLong(KEY_NAME: String) = sharedPref.getLong(KEY_NAME, 0)

    fun getValueBoolien(KEY_NAME: String, defaultValue: Boolean)
            = sharedPref.getBoolean(KEY_NAME, defaultValue)

    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.clear()
        editor.commit()
    }

    fun removeValue(KEY_NAME: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.remove(KEY_NAME)
        editor.commit()
    }

    companion object {

        private const val PREF = "PREF"
        const val TOKEN = "TOKEN"
        const val FCM_ID = "FCM_ID"
        const val VIRAL = "VIRAL"
        const val EVENT_CHECK_CURRENT_DATE = "EVENT_CHECK_CURRENT_DATE"

    }


}