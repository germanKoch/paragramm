package com.paragramm.paragrammcore.controller

import com.paragramm.paragrammcore.domain.model.Conversation
import com.paragramm.paragrammcore.repository.model.ConversationEntity
import com.paragramm.paragrammcore.usecase.ConversationUseCase
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
@RequestMapping("/api/conversation")
class ConversationController(
    private val useCase: ConversationUseCase
) {

    @GetMapping
    fun getAll(principal: Principal): Flux<Conversation> {
        return useCase.findAllForUser(principal.name)
    }

    @GetMapping("/after/{lastId}")
    fun getAll(principal: Principal, @PathVariable lastId: Long): Flux<Conversation> {
        return useCase.findAllForUserAfter(principal.name, lastId)
    }

    @PostMapping
    fun save(principal: Principal, @RequestBody conversation: Conversation): Mono<Conversation> {
        return useCase.createConversation(principal.name, conversation)
    }
}