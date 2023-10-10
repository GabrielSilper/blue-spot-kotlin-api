package org.pdm.bluespot.core.dtos.users

import org.pdm.bluespot.core.entities.users.Landlord
import org.pdm.bluespot.core.entities.users.Tenant

data class UserCreationDto(
    val name: String,
    val document: String,
    val email: String,
    val password: String
) {
    fun toLandlord(): Landlord {
        return Landlord(null, name, document, email, password)
    }

    fun toTenant(): Tenant {
        return Tenant(null, name, document, email, password)
    }
}
