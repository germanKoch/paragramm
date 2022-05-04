package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.repository.MessageRepository
import com.paragramm.paragrammcore.repository.model.Message
import com.paragramm.paragrammcore.usecase.MessageUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class MessageUseCaseImpl(
    private val repository: MessageRepository
) : MessageUseCase {

    override fun findAll(conversationId: Long): Flux<Message> {
        return repository.findByConversationId(conversationId)
    }

    override fun findAllAfter(conversationId: Long, lastId: Long): Flux<Message> {
        return repository.findByConversationIdAndIdGreaterThan(conversationId, lastId)
    }


}