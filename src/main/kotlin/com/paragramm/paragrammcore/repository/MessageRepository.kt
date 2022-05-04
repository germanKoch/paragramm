package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface MessageRepository: ReactiveCrudRepository<Message, Long> {

    fun findByConversationId(conversationId: Long): Flux<Message>

    fun findByConversationIdAndIdGreaterThan(conversationId: Long, messageId: Long): Flux<Message>

}