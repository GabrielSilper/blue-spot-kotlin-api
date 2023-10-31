package org.pdm.bluespot.mocks

import org.pdm.bluespot.core.entities.users.Landlord
import org.pdm.bluespot.core.enums.CivilState

val mockLandlord = Landlord(
    null,
    "John",
    "john@test.com",
    "123456789",
    "92 99999 9999",
    "Brasileiro",
    CivilState.SOLTEIRO,
    "Occupation",
    "123456789",
    "123456789",
    "Address",
)

val mockResultLandlord = Landlord(
    "653352ad7d213c17a1d0fc5e",
    "John",
    "john@test.com",
    "123456789",
    "92 99999 9999",
    "Brasileiro",
    CivilState.SOLTEIRO,
    "Occupation",
    "123456789",
    "123456789",
    "Address",
    mutableListOf()
)

val mockLandlordWithProperties = Landlord(
    "653352ad7d213c17a1d0fc5e",
    "John",
    "john@test.com",
    "123456789",
    "92 99999 9999",
    "Brasileiro",
    CivilState.SOLTEIRO,
    "Occupation",
    "123456789",
    "123456789",
    "Address",
    mutableListOf(mockResultAddProperty, mockResultAddProperty)
)