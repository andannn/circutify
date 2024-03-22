package com.andannn.circutify

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import com.andannn.circutiry.core.network.SpotifyAccountService
import com.andannn.circutiry.core.network.auth.generateAuthorizationUrl
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private val repo by inject<SpotifyAccountService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFlow()
    }

    private var loginJob: Job? = null
    private val fallBackEventFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

    private fun loginFlow() {
        loginJob?.cancel()
        loginJob =
            lifecycleScope.launch {
                val (uri, codeVerifier) = resources.generateAuthorizationUrl()
                CustomTabsIntent.Builder().build()
                    .launchUrl(this@MainActivity, uri)
                val code = awaitFallBack()
                Timber.tag(TAG).d("login success.")

                try {
                    repo.getToken(resources, code = code, codeVerifier = codeVerifier)
                } catch (e: Exception) {
                    Timber.tag(TAG).e("loginFlow: $e")
                }
            }
    }

    private suspend fun awaitFallBack(): String {
        return fallBackEventFlow.first()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (intent?.data?.scheme == "circutify") {
            fallBackEventFlow.tryEmit(
                intent.data!!.getQueryParameter("code")
                    ?: error("no parameter **code** in fallback url"),
            )
        }
    }
}
