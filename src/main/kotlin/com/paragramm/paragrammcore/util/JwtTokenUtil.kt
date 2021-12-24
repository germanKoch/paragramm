package com.paragramm.paragrammcore.util

import com.paragramm.paragrammcore.repository.model.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Base64
import java.util.Date
import javax.crypto.spec.SecretKeySpec

@Component
class JwtTokenUtil(
    @Value("\${auth.secret-key}") secretKeyStr: String,
    @Value("\${auth.expiration-hours}") expirationHours: Long
) {

    private val secretKey = BASE64.decode(secretKeyStr)
    private val expirationDuration = Duration.of(expirationHours, ChronoUnit.HOURS)

    fun generateToken(user: User): String {
        val nowInstant = Instant.now()

        val now = Date.from(nowInstant)
        val expiration = Date.from(nowInstant + expirationDuration)

        return Jwts.builder()
            .setSubject(user.username)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SecretKeySpec(secretKey, ALGORITHM))
            .compact()
    }

    fun validateToken(token: String): Jws<Claims> {
        return Jwts.parserBuilder().setSigningKey(SecretKeySpec(secretKey, ALGORITHM)).build()
            .parseClaimsJws(token)
    }

    companion object {
        private const val ALGORITHM = "HmacSHA256"

        private val BASE64 = Base64.getDecoder()
    }

}