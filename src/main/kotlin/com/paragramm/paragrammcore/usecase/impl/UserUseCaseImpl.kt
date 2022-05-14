package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.repository.model.UserEntity
import com.paragramm.paragrammcore.usecase.UserUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
@Transactional
class UserUseCaseImpl(
    private val repository: UserRepository
) : UserUseCase {

    override fun getByUsername(username: String): Mono<UserEntity> {
        return repository.findByUsername(username)
    }

}