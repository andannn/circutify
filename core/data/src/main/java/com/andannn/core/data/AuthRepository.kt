package com.andannn.core.data

import android.net.Uri
import java.lang.Exception

sealed interface LoginResult {
    data object Success : LoginResult

    data class Failed(val exception: Exception) : LoginResult
}

interface AuthRepository {
    suspend fun loginFlow(onLaunchLoginPage: (Uri) -> Unit): LoginResult

    fun notifyLoginFailedBack(code: String)
}
