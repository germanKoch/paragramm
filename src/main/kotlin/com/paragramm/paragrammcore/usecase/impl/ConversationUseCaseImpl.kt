package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.domain.model.Conversation
import com.paragramm.paragrammcore.repository.ConversationRepository
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.usecase.ConversationUseCase
import com.paragramm.paragrammcore.usecase.mappers.ConversationMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZonedDateTime

@Service
@Transactional
class ConversationUseCaseImpl(
    private val repository: ConversationRepository,
    private val userRepository: UserRepository,
    private val conversationMapper: ConversationMapper
) : ConversationUseCase {

    override fun findAllForUser(username: String): Flux<Conversation> {
        return userRepository.findByUsername(username).flatMapMany {
            repository.findByUserId(it.id!!)
        }.map(conversationMapper::map)
    }

    override fun findAllForUserAfter(username: String, lastId: Long): Flux<Conversation> {
        return userRepository.findByUsername(username).flatMapMany {
            repository.findByUserIdAndIdGreaterThan(it.id!!, lastId)
        }.map(conversationMapper::map)
    }

    override fun createConversation(username: String, conversation: Conversation): Mono<Conversation> {
        TODO()

//        return userRepository.findByUsername(username).flatMap { userEntity ->
//            conversationMapper.map(preparedConversation).let { conversationEntity ->
//                repository.save(conversationEntity).doOnEach { savedConversationEntity ->
//                    repository.assignConversationToUser(
//                        userEntity.id!!, savedConversationEntity.get()!!.id!!, ZonedDateTime.now()
//                    )
//                }
//            }
//        }.map { something ->
//            conversationMapper.map(something)
//        }
    }

    private fun Conversation.prepare(): Conversation {
        return this.copy(creationDate = ZonedDateTime.now())
    }
}