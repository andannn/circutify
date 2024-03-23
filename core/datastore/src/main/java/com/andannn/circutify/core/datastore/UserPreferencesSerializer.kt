package com.andannn.circutify.core.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

class CircutifyPreferencesSerializer : Serializer<CircutifyPreferences> {
    override val defaultValue: CircutifyPreferences = CircutifyPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): CircutifyPreferences =
        try {
            // readFrom is already called on the data store background thread
            @Suppress("BlockingMethodInNonBlockingContext")
            CircutifyPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(
        t: CircutifyPreferences,
        output: OutputStream,
    ) {
        // writeTo is already called on the data store background thread
        @Suppress("BlockingMethodInNonBlockingContext")
        t.writeTo(output)
    }
}
