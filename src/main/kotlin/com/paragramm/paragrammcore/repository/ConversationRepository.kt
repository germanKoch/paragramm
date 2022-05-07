package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.Conversation
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ConversationRepository : ReactiveCrudRepository<Conversation, Long> {

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id)")
    fun findByUserId(userId: Long): Flux<Conversation>

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id) AND c.id > :lastId")
    fun findByUserIdAndIdGreaterThan(userId: Long, lastId: Long): Flux<Conversation>

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id) AND c.id = :id")
    fun findByUserIdAndId(userId: Long, id: Long): Mono<Conversation>

}