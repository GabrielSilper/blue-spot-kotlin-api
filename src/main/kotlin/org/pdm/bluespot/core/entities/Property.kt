package org.pdm.bluespot.core.entities

import org.pdm.bluespot.core.enums.PropertyType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Property(
    @Id var id: String?,
    var landlordId: String?,
    var address: String,
    var price: Double,
    var propertyType: PropertyType,
    var restrictions: MutableList<String> = ArrayList<String>(),
    var furnishings: MutableList<String> = ArrayList<String>(),
    var hasGarage: Boolean,
    var isAvailable: Boolean,
    var isVerified: Boolean
) {
}