package org.pdm.bluespot.core.usercases

import org.pdm.bluespot.core.entities.Property

interface LandlordUserCase {
    fun addProperty(landlordId: String, property: Property): Property
    fun listProperties(landlordId: String): List<Property>
    fun removeProperty(landlordId: String, propertyId: String)
}