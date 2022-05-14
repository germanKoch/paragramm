package com.paragramm.paragrammcore.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.time.ZonedDateTime

@Table("conversation")
class ConversationEntity(
    @Id private var id: Long?,
    val title: String?,
    val picture: String?,
    val creationDate: ZonedDateTime?
) : Persistable<Long> {

    override fun getId(): Long? = id

    fun setId(id: Long?) {
        this.id = id
    }

    override fun isNew(): Boolean = id == null

}