package org.pdm.bluespot.core.dtos.users

import org.pdm.bluespot.core.enums.CivilState
import org.pdm.bluespot.core.entities.users.Landlord
import org.pdm.bluespot.core.entities.users.Tenant

data class UserCreationDto(
    val name: String,
    val email: String,
    val password: String,
    val phone: String,
    val nationality: String,
    val civilState: CivilState,
    val occupation: String,
    val rg: String,
    val cpf: String,
    val address: String
) {
    fun toLandlord(): Landlord {
        return Landlord(
            null,
            name,
            email,
            password,
            phone,
            nationality,
            civilState,
            occupation,
            rg,
            cpf,
            address
        )
    }

    fun toTenant(): Tenant {
        return Tenant(
            null,
            name,
            email,
            password,
            phone,
            nationality,
            civilState,
            occupation,
            rg,
            cpf,
            address
        )
    }
}
