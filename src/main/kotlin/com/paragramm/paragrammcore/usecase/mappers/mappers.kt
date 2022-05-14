package com.paragramm.paragrammcore.usecase.mappers

import com.paragramm.paragrammcore.domain.model.Conversation
import com.paragramm.paragrammcore.domain.model.Message
import com.paragramm.paragrammcore.repository.model.ConversationEntity
import com.paragramm.paragrammcore.repository.model.MessageEntity
import org.mapstruct.Mapper
import org.mapstruct.MapperConfig
import org.mapstruct.MappingConstants
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValueMappingStrategy
import org.mapstruct.ReportingPolicy

@MapperConfig(
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    componentModel = MappingConstants.ComponentModel.SPRING
)
interface DefaultConfig

@Mapper(
    config = DefaultConfig::class
)
interface ConversationMapper {

    fun map(entity: ConversationEntity): Conversation

    fun map(model: Conversation): ConversationEntity

}

@Mapper(
    config = DefaultConfig::class
)
interface MessageMapper {

    fun map(entity: MessageEntity): Message

    fun map(model: Message): MessageEntity

}