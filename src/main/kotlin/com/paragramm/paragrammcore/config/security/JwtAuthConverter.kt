package com.paragramm.paragrammcore.config.security

import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class JwtAuthConverter : ServerAuthenticationConverter {

    override fun convert(exchange: ServerWebExchange?): Mono<Authentication> {
        return Mono.justOrEmpty(exchange)
            .map { it.request.headers[HttpHeaders.AUTHORIZATION] ?: listOf() }
            .filter { it.size == 1 }
            .map { it.single() }
            .map { UsernamePasswordAuthenticationToken(it, it) }
    }

}