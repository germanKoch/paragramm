package com.paragramm.paragrammcore.repository.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.time.ZonedDateTime

@Table("user_details")
data class User(
    @Id private var id: Long?,
    val name: String,
    val phone: String,
    val username: String,
    val password: String,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssz")
    val creationDate: ZonedDateTime
) : Persistable<Long> {

    fun setId(id: Long?) {
        this.id = id
    }

    override fun getId(): Long? = id

    override fun isNew(): Boolean = id == null

}