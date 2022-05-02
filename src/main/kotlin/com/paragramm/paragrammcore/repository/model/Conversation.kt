package com.paragramm.paragrammcore.repository.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import java.time.ZonedDateTime

class Conversation(
    @Id private var id: Long?,
    val title: String?,
    val picture: String?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssz")
    val creationDate: ZonedDateTime?
) : Persistable<Long> {

    override fun getId(): Long? = id

    fun setId(id: Long?) {
        this.id = id
    }

    override fun isNew(): Boolean = id == null

}