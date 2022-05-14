package com.paragramm.paragrammcore.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class AuthRequest(
    val username: String,
    val password: String
)

data class AuthResponse(
    val token: String?
)


data class Conversation(
    val id: Long?,
    val title: String?,
    val picture: String?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssz")
    val creationDate: ZonedDateTime?
)

data class Message(
    val id: Long?,
    val conversationId: Long,
    val senderId: Long?,
    val text: String?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssz")
    val creationDate: ZonedDateTime?
)