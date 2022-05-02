package com.paragramm.paragrammcore.controller.resource

data class AuthRequest(
    val username: String,
    val password: String
)

data class AuthResponse(
    val token: String?
)