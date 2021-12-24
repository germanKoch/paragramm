package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.MessageRepository
import com.paragramm.paragrammcore.repository.model.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class MessageUseCase(
    private val repository: MessageRepository
) {

    fun getAll(): Flux<Message> {
        return repository.findAll()
    }

}