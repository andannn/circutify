package com.andannn.circutify

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import com.andannn.core.data.AuthRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val repo by inject<AuthRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLoginButtonClick()
    }

    private var loginJob: Job? = null

    private fun onLoginButtonClick() {
        loginJob?.cancel()
        loginJob =
            lifecycleScope.launch {
                repo.loginFlow {
                    CustomTabsIntent.Builder().build().launchUrl(this@MainActivity, it)
                }
            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (intent?.data?.scheme == "circutify") {
            repo.notifyLoginFailedBack(
                intent.data!!.getQueryParameter("code")
                    ?: error("no parameter **code** in fallback url"),
            )
        }
    }
}
