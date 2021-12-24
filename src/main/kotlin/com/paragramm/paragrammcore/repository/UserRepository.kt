package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveCrudRepository<User, Long> {

    fun findByUsername(username: String): Mono<User>

}