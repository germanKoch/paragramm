package com.paragramm.paragrammcore.usecase.impl

import com.paragramm.paragrammcore.domain.model.AuthRequest
import com.paragramm.paragrammcore.domain.model.AuthResponse
import com.paragramm.paragrammcore.domain.exception.UnauthorizedException
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.usecase.AuthUseCase
import com.paragramm.paragrammcore.util.JwtTokenUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
@Transactional
class AuthUseCaseImpl(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtTokenUtil,
): AuthUseCase {

    override fun authenticate(request: AuthRequest): Mono<AuthResponse> {
        return userRepository.findByUsername(request.username).filter {
            it.password == request.password
        }
            .map { user -> AuthResponse(jwtUtil.generateToken(user)) }
            .switchIfEmpty { throw UnauthorizedException("Invalid credentials") }
    }

}