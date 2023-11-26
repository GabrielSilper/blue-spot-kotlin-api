package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.exceptions.PropertyNotFoundException
import org.pdm.bluespot.core.repositories.PropertyRepository
import org.springframework.stereotype.Service

@Service
class PropertyService(private val propertyRepository: PropertyRepository): IPropertyService {
    override fun createProperty(data: Property): Property {
        return this.propertyRepository.save(data)
    }

    override fun getPropertyById(id: String): Property {
        return this.propertyRepository.findById(id).orElseThrow { PropertyNotFoundException() }
    }

    override fun getAllProperties(): List<Property> {
        return this.propertyRepository.findAll()
    }
}