package com.paragramm.paragrammcore

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class ParagrammCoreApplication

fun main(args: Array<String>) {
    runApplication<ParagrammCoreApplication>(*args)
}
