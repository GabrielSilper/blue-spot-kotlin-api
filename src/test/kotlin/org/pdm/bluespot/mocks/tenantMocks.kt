package org.pdm.bluespot.mocks

import org.pdm.bluespot.core.dtos.UserCreationDto
import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.core.enums.CivilState

val mockTenant = UserCreationDto(
    "Fulano",
    "fulano@gmail.com",
    "12345678",
    "92 99999 9999",
    "Brasileiro",
    CivilState.CASADO,
    "Desempregado",
    "12345678-9",
    "333.333.333-33",
    "Rua dos Bobos, 0",
).toTenant()

val mockResultTenant = Tenant(
    "653352ad7d213c17a1d0fc5e",
    "Fulano",
    "fulano@gmail.com",
    "12345678",
    "92 99999 9999",
    "Brasileiro",
    CivilState.CASADO,
    "Desempregado",
    "12345678-9",
    "333.333.333-33",
    "Rua dos Bobos, 0",
)