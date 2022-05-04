package com.paragramm.paragrammcore.config.db

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@Configuration
@EnableR2dbcRepositories
class DbConfig(
    @Value("\${db.host}") val host: String,
    @Value("\${db.port}") val port: Int,
    @Value("\${db.db}") val db: String,
    @Value("\${db.username}") val username: String,
    @Value("\${db.password}") val password: String
) : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(db)
                .build()
        )
    }

    override fun getCustomConverters(): MutableList<Any> {
        return mutableListOf()
    }
}