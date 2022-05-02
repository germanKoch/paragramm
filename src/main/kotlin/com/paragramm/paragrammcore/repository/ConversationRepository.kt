package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.Conversation
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ConversationRepository : ReactiveCrudRepository<Conversation, Long> {

    @Query("SELECT * FROM user_conversation uc LEFT JOIN conversation c ON uc.conversation_id = c.id WHERE user_id=:user_id ")
    fun findByUserId(userId: Long): Flux<Conversation>

    @Query("SELECT * FROM user_conversation uc LEFT JOIN conversation c ON uc.conversation_id = c.id WHERE user_id=:user_id AND c.id > :lastId")
    fun findByUserIdAndIdGreaterThan(userId: Long, lastId: Long): Flux<Conversation>

}