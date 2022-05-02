package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.User
import com.paragramm.paragrammcore.usecase.UserUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserUseCaseImpl(
    private val repository: UserRepository
) : UserUseCase {

    override fun getByUsername(username: String): Mono<User> {
        return repository.findByUsername(username)
    }

}