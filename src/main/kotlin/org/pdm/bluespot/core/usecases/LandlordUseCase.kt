package org.pdm.bluespot.core.usecases

import org.pdm.bluespot.core.entities.Property

interface LandlordUseCase {
    fun addProperty(landlordId: String, property: Property): Property
    fun listProperties(landlordId: String): List<Property>
    fun listProperties(landlordId: String, available: Boolean): List<Property>
    fun removeProperty(landlordId: String, propertyId: String)
}