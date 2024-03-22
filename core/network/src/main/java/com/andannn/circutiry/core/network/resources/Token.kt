package com.andannn.circutiry.core.network.resources

import io.ktor.resources.Resource

@Resource("/api/token")
class Token(
    val grant_type: String,
    val code: String,
    val client_id: String,
    val redirect_uri: String,
    val code_verifier: String,
)
