package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.ConversationEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZonedDateTime

interface ConversationRepository : ReactiveCrudRepository<ConversationEntity, Long> {

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id)")
    fun findByUserId(userId: Long): Flux<ConversationEntity>

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id) AND c.id > :lastId")
    fun findByUserIdAndIdGreaterThan(userId: Long, lastId: Long): Flux<ConversationEntity>

    @Query("SELECT * FROM conversation c WHERE c.id IN (SELECT conversation_id FROM user_conversation uc WHERE uc.user_id = :user_id) AND c.id = :id")
    fun findByUserIdAndId(userId: Long, id: Long): Mono<ConversationEntity>

    @Query("INSERT INTO user_conversation(conversation_id, user_id, creation_date) VALUES (:conversationId, :userId, :creationDate)")
    fun assignConversationToUser(userId: Long, conversationId: Long, creationDate: ZonedDateTime): Mono<Void>

}