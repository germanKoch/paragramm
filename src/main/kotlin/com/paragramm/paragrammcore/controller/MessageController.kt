package com.paragramm.paragrammcore.controller

import com.paragramm.paragrammcore.domain.model.Message
import com.paragramm.paragrammcore.repository.model.MessageEntity
import com.paragramm.paragrammcore.usecase.MessageUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.security.Principal

@RestController
@RequestMapping("/api/message")
class MessageController(
    private val messageUseCase: MessageUseCase
) {

    @GetMapping("/{conversationId}")
    fun getAll(@PathVariable conversationId: Long, principal: Principal): Flux<Message> {
        return messageUseCase.findAll(conversationId, principal.name)
    }

    @GetMapping("/{conversationId}/after/{lastId}")
    fun getAllAfter(
        @PathVariable conversationId: Long,
        @PathVariable lastId: Long,
        principal: Principal
    ): Flux<Message> {
        return messageUseCase.findAllAfter(conversationId, lastId, principal.name)
    }

    @PostMapping("/")
    fun save(principal: Principal, @RequestBody message: MessageEntity): Mono<Message> {
        TODO()
    }
}