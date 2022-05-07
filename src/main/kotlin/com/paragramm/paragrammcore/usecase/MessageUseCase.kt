package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.model.Message
import reactor.core.publisher.Flux

interface MessageUseCase {

    fun findAll(conversationId: Long, username: String): Flux<Message>

    fun findAllAfter(conversationId: Long, lastId: Long, username: String): Flux<Message>

}