package com.paragramm.paragrammcore.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("user_details")
data class User(
    @Id private var id: Long?,
    val name: String,
    val phone: String,
    val username: String,
    val password: String,
): Persistable<Long> {

    fun setId(id: Long?) {
        this.id = id
    }

    override fun getId(): Long? = id

    override fun isNew(): Boolean = id == null

}