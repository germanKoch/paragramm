package com.paragramm.paragrammcore.controller

import com.paragramm.paragrammcore.repository.model.Message
import com.paragramm.paragrammcore.usecase.MessageUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/message")
class MessageController(
    private val messageUseCase: MessageUseCase
) {

    @GetMapping("/{conversationId}")
    fun getAll(@PathVariable conversationId: Long): Flux<Message> {
        return messageUseCase.findAll(conversationId)
    }

    @GetMapping("/{conversationId}/after/{lastId}")
    fun getAllAfter(@PathVariable conversationId: Long, @PathVariable lastId: Long): Flux<Message> {
        return messageUseCase.findAllAfter(conversationId, lastId)
    }
}