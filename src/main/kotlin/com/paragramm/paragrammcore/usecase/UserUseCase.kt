package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.model.UserEntity
import reactor.core.publisher.Mono

interface UserUseCase {

    fun getByUsername(username: String): Mono<UserEntity>

}