package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveCrudRepository<UserEntity, Long> {

    fun findByUsername(username: String): Mono<UserEntity>

}