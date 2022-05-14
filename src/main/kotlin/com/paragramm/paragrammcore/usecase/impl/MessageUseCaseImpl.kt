package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.domain.model.Message
import com.paragramm.paragrammcore.repository.ConversationRepository
import com.paragramm.paragrammcore.repository.MessageRepository
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.usecase.MessageUseCase
import com.paragramm.paragrammcore.usecase.mappers.MessageMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class MessageUseCaseImpl(
    private val repository: MessageRepository,
    private val conversationRepository: ConversationRepository,
    private val userRepository: UserRepository,
    private val messageMapper: MessageMapper
) : MessageUseCase {

    override fun findAll(conversationId: Long, username: String): Flux<Message> {
        return userRepository.findByUsername(username)
            .flatMap {
                conversationRepository.findByUserIdAndId(it.id!!, conversationId)
            }.flatMapMany {
                repository.findByConversationId(it.id!!)
            }.map(messageMapper::map)
    }

    override fun findAllAfter(conversationId: Long, lastId: Long, username: String): Flux<Message> {
        return userRepository.findByUsername(username)
            .flatMap {
                conversationRepository.findByUserIdAndId(it.id!!, conversationId)
            }.flatMapMany {
                repository.findByConversationIdAndIdGreaterThan(it.id!!, lastId)
            }.map(messageMapper::map)
    }

    override fun createMessage(username: String, message: Message): Mono<Message> {
        TODO("Not yet implemented")
    }

}