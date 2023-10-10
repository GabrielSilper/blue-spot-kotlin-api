package org.pdm.bluespot.core.dtos

import org.pdm.bluespot.core.entities.Property

data class PropertyCreationDto(
    var address: String,
    var price: Double,
    var restrictions: MutableList<String> = ArrayList<String>(),
    var furnishings: MutableList<String> = ArrayList<String>()
) {
    fun toProperty(): Property {
        return Property(null, address, price, restrictions, furnishings)
    }
}
