package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.model.Conversation
import reactor.core.publisher.Flux

interface ConversationUseCase {

    fun findAllForUser(username: String): Flux<Conversation>

    fun findAllForUserAfter(username: String, lastId: Long): Flux<Conversation>

}