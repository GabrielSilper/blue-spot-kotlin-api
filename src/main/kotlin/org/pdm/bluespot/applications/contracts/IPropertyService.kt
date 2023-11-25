package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Property

interface IPropertyService {
    fun createProperty(data: Property): Property
    fun getPropertyById(id: String): Property
    fun getAllProperties(): List<Property>
}