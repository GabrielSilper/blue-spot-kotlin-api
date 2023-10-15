package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.usecases.PropertyUseCase


interface IPropertyService: PropertyUseCase {
    fun create(data: Property): Property
    fun findById(id: String): Property
    fun update(id: String, data: Property): Property
    fun findAll(): List<Property>
    fun delete(id: String)
}