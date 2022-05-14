package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.MessageEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface MessageRepository: ReactiveCrudRepository<MessageEntity, Long> {

    fun findByConversationId(conversationId: Long): Flux<MessageEntity>

    fun findByConversationIdAndIdGreaterThan(conversationId: Long, messageId: Long): Flux<MessageEntity>

}