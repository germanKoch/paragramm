package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.User
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserUseCase(
    private val repository: UserRepository
) {

    fun getByUsername(username: String): Mono<User> {
        return repository.findByUsername(username)
    }

}