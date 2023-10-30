package org.pdm.bluespot.mocks

import org.pdm.bluespot.core.dtos.PropertyCreationDto
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.enums.PropertyType


val mockProperty: Property = PropertyCreationDto(
    "Address",
    "Description",
    1000.0,
    PropertyType.RESIDENCIAL,
    mutableListOf("Proibido fumar"),
    mutableListOf("Sofá"),
    hasGarage = true
).toProperty()

val mockResultProperty = Property(
    "653352ad7d213c17a1d6fte",
    null,
    mutableListOf(),
    "Description",
    "Address",
    1000.0,
    PropertyType.RESIDENCIAL,
    mutableListOf("Proibido fumar"),
    mutableListOf("Sofá"),
    hasGarage = true,
    isAvailable = true,
    isVerified = false
)

val mockResultAddProperty = Property(
    "653352ad7d213c17a1d6fte",
    "653352ad7d213c17a1d0fc5e",
    mutableListOf("image1", "image2"),
    "Description",
    "Address",
    1000.0,
    PropertyType.RESIDENCIAL,
    mutableListOf("Proibido fumar"),
    mutableListOf("Sofá"),
    hasGarage = true,
    isAvailable = true,
    isVerified = false
)

