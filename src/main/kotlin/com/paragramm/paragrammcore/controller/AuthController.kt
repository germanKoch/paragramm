package com.paragramm.paragrammcore.controller

import com.paragramm.paragrammcore.domain.model.AuthRequest
import com.paragramm.paragrammcore.domain.model.AuthResponse
import com.paragramm.paragrammcore.usecase.AuthUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authUseCase: AuthUseCase
) {

    @PostMapping
    fun authenticate(@RequestBody request: AuthRequest): Mono<ResponseEntity<AuthResponse>> {
        return authUseCase.authenticate(request).map { ResponseEntity.ok(it) }
    }

}