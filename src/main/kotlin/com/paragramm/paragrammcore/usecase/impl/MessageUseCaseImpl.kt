package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.repository.ConversationRepository
import com.paragramm.paragrammcore.repository.MessageRepository
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.Message
import com.paragramm.paragrammcore.usecase.MessageUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class MessageUseCaseImpl(
    private val repository: MessageRepository,
    private val conversationRepository: ConversationRepository,
    private val userRepository: UserRepository
) : MessageUseCase {

    override fun findAll(conversationId: Long, username: String): Flux<Message> {
        return userRepository.findByUsername(username)
            .flatMap {
                conversationRepository.findByUserIdAndId(it.id!!, conversationId)
            }.flatMapMany {
                repository.findByConversationId(it.id!!)
            }
    }

    override fun findAllAfter(conversationId: Long, lastId: Long, username: String): Flux<Message> {
        return userRepository.findByUsername(username)
            .flatMap {
                conversationRepository.findByUserIdAndId(it.id!!, conversationId)
            }.flatMapMany {
                repository.findByConversationIdAndIdGreaterThan(it.id!!, lastId)
            }
    }


}