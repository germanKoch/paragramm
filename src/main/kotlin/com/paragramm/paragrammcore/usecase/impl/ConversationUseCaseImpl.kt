package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.repository.ConversationRepository
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.Conversation
import com.paragramm.paragrammcore.usecase.ConversationUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ConversationUseCaseImpl(
    private val repository: ConversationRepository,
    private val userRepository: UserRepository
) : ConversationUseCase {

    override fun findAllForUser(username: String): Flux<Conversation> {
        return userRepository.findByUsername(username).flatMapMany {
            repository.findConversationsByUserId(it.id!!)
        }
    }

}