package com.paragramm.paragrammcore.repository.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import java.time.ZonedDateTime

data class Message(
    @Id private var id: Long?,
    val conversationId: Long,
    val senderId: Long?,
    val text: String?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssz")
    val creationDate: ZonedDateTime?
) : Persistable<Long> {

    override fun getId(): Long? = id

    fun setId(id: Long?) {
        this.id = id
    }

    override fun isNew(): Boolean = id == null
}
