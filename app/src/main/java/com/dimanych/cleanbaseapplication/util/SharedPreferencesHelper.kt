package com.dimanych.cleanbaseapplication.util

import android.content.Context
import android.content.SharedPreferences
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesHelper @Inject constructor(context: Context) {

    private val preferences: SharedPreferences = context
            .getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    fun put(key: String, value: Boolean) {
        preferences
                .edit()
                .putBoolean(key, value)
                .apply()
    }

    fun put(key: String, value: String?) {
        preferences
                .edit()
                .putString(key, value)
                .apply()
    }

    fun put(key: String, value: Int) {
        preferences
                .edit()
                .putInt(key, value)
                .apply()
    }

    //TODO temporally decision, MIGRATE TO DATABASE
    fun putImagesData(values: List<ImageData>): Completable {
        val items = values.map { it.imgSource }
        preferences
                .edit()
                .putStringSet("images_data", items.toHashSet())
                .apply()
        return Completable.complete()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
            preferences.getBoolean(key, defaultValue)

    fun getString(key: String): String =
            preferences.getString(key, "")

    fun getString(key: String, defaultValue: String): String? =
            preferences.getString(key, defaultValue)

    fun getInt(key: String, defaultValue: Int): Int = preferences.getInt(key, defaultValue)

    //TODO temporally decision, MIGRATE TO DATABASE
    fun getImagesList(): Single<List<ImageData>> {
        return Single.fromCallable {
            return@fromCallable preferences.getStringSet("images_data", setOf())
                    .map { ImageData(it) }
                    .toMutableList()
        }
    }

}
