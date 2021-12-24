package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.ConversationRepository
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.Conversation
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ConversationUseCase(
    private val repository: ConversationRepository,
    private val userRepository: UserRepository
) {

    fun findAllForUser(username: String): Flux<Conversation> {
        return userRepository.findByUsername(username).flatMapMany {
            repository.findConversationsByUserId(it.id!!)
        }
    }

}