package com.andannn.circutify

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import com.andannn.core.data.AuthRepository
import com.andannn.core.data.ResourceRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private val authRepo by inject<AuthRepository>()
    private val resourceRepo by inject<ResourceRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        onLoginButtonClick()

        lifecycleScope.launch {
            resourceRepo.getAlbumById("4aawyAB9vmqN3uQ7FjRGTy").also {
                Timber.tag(TAG).d("onCreate: $it")
            }
        }
    }

    private var loginJob: Job? = null

    private fun onLoginButtonClick() {
        loginJob?.cancel()
        loginJob =
            lifecycleScope.launch {
                authRepo.loginFlow {
                    CustomTabsIntent.Builder().build().launchUrl(this@MainActivity, it)
                }
            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (intent?.data?.scheme == "circutify") {
            authRepo.notifyLoginFailedBack(
                intent.data!!.getQueryParameter("code")
                    ?: error("no parameter **code** in fallback url"),
            )
        }
    }
}
