package com.andannn.circutify.core.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.andannn.circutify.core.datastore.CircutifyDataStore
import com.andannn.circutify.core.datastore.CircutifyDataStoreImpl
import com.andannn.circutify.core.datastore.CircutifyPreferences
import com.andannn.circutify.core.datastore.CircutifyPreferencesSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule =
    module {
        single<DataStore<CircutifyPreferences>> {
            DataStoreFactory.create(
                serializer = CircutifyPreferencesSerializer(),
                scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            ) {
                androidContext().dataStoreFile("circutify_preferences.pb")
            }
        }

        single<CircutifyDataStore> { CircutifyDataStoreImpl(get()) }
    }
