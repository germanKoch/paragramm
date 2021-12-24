package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.controller.resource.AuthRequest
import com.paragramm.paragrammcore.controller.resource.AuthResponse
import com.paragramm.paragrammcore.domain.exception.UnauthorizedException
import com.paragramm.paragrammcore.repository.UserRepository
import com.paragramm.paragrammcore.util.JwtTokenUtil
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class AuthUseCase(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtTokenUtil,
) {

    fun authenticate(request: AuthRequest): Mono<AuthResponse> {
        return userRepository.findByUsername(request.username).filter {
            it.password == request.password
        }
            .map { user -> AuthResponse(jwtUtil.generateToken(user)) }
            .switchIfEmpty { throw UnauthorizedException("Invalid credentials") }
    }

}