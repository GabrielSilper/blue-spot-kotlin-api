package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Property


interface IPropertyService {
    fun create(data: Property): Property
    fun findById(id: String): Property
    fun findAll(): List<Property>
    fun update(id: String, data: Property): Property
    fun delete(id: String)
}