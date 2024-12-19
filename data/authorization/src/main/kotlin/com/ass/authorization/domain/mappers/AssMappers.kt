package com.ass.authorization.domain.mappers

import com.ass.authorization.domain.models.AssUser
import com.ass.core.storage.entity.AssUserEntity

fun AssUserEntity.toDomain(): AssUser {
    return AssUser(
        name = this.name,
        secondName = this.secondName,
        email = this.email,
        phone = this.phone
    )
}

fun AssUser.toEntity(): AssUserEntity {
    return AssUserEntity(
        name = this.name,
        secondName = this.secondName,
        email = this.email,
        phone = this.phone
    )
}