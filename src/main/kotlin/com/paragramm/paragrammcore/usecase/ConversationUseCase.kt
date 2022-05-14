package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.domain.model.Conversation
import com.paragramm.paragrammcore.repository.model.ConversationEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ConversationUseCase {

    fun findAllForUser(username: String): Flux<Conversation>

    fun findAllForUserAfter(username: String, lastId: Long): Flux<Conversation>

    fun createConversation(username: String, conversation: Conversation): Mono<Conversation>

}