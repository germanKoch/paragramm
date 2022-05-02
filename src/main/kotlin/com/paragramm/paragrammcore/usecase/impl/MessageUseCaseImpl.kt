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

    override fun getAll(): Flux<Message> {
        return repository.findAll()
    }

}