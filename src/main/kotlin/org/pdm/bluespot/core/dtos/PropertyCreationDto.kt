package org.pdm.bluespot.core.dtos

import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.enums.PropertyType

data class PropertyCreationDto(
    var address: String,
    var description: String,
    var price: Double,
    var propertyType: PropertyType,
    var restrictions: MutableList<String> = ArrayList<String>(),
    var furnishings: MutableList<String> = ArrayList<String>(),
    var hasGarage: Boolean,
) {
    fun toProperty(): Property {
        return Property(
            id = null,
            landlordId = null,
            images = listOf(),
            description,
            address,
            price,
            propertyType,
            restrictions,
            furnishings,
            hasGarage,
            isAvailable = true,
            isVerified = false
        )
    }
}
