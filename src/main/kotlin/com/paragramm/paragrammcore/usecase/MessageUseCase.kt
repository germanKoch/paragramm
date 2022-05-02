package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.model.Message
import reactor.core.publisher.Flux

interface MessageUseCase {

    fun getAll(): Flux<Message>

}