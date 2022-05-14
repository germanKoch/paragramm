package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.domain.model.AuthRequest
import com.paragramm.paragrammcore.domain.model.AuthResponse
import reactor.core.publisher.Mono

interface AuthUseCase {

    fun authenticate(request: AuthRequest): Mono<AuthResponse>

}