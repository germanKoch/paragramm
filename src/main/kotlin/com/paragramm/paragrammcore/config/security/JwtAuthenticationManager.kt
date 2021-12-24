package com.paragramm.paragrammcore.config.security

import com.paragramm.paragrammcore.domain.exception.UnauthorizedException
import com.paragramm.paragrammcore.util.JwtTokenUtil
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class JwtAuthenticationManager(
    val jwtUtil: JwtTokenUtil
) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        return Mono.just(authentication)
            .map { authentication.credentials as String }
            .map { jwtUtil.validateToken(it) }
            .onErrorResume { throw UnauthorizedException("Invalid token") }
            .map {
                UsernamePasswordAuthenticationToken(
                    it.body.subject, authentication.credentials as String, mutableListOf(
                        SimpleGrantedAuthority("ROLE_USER")
                    )
                )
            }
    }

}