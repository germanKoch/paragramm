package com.paragramm.paragrammcore.repository

import com.paragramm.paragrammcore.repository.model.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MessageRepository: ReactiveCrudRepository<Message, Long>