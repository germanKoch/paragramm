package com.paragramm.paragrammcore.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable

class Conversation(
    @Id private var id: Long?,
    val title: String?,
    val picture: String?,
) : Persistable<Long> {

    override fun getId(): Long? = id

    fun setId(id: Long?) {
        this.id = id
    }

    override fun isNew(): Boolean = id == null

}