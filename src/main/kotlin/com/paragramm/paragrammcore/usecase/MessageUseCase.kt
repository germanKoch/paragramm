package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.domain.model.Message
import com.paragramm.paragrammcore.repository.model.MessageEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MessageUseCase {

    fun findAll(conversationId: Long, username: String): Flux<Message>

    fun findAllAfter(conversationId: Long, lastId: Long, username: String): Flux<Message>

    fun createMessage(username: String, message: Message): Mono<Message>

}