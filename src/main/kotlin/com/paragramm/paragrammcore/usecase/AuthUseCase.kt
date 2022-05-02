package com.paragramm.paragrammcore.usecase

import com.paragramm.paragrammcore.controller.resource.AuthRequest
import com.paragramm.paragrammcore.controller.resource.AuthResponse
import reactor.core.publisher.Mono

interface AuthUseCase {

    fun authenticate(request: AuthRequest): Mono<AuthResponse>

}