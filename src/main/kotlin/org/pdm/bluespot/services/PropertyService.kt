package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.exceptions.PropertyNotFoundException
import org.pdm.bluespot.core.repositories.PropertyRepository
import org.springframework.stereotype.Service

@Service
class PropertyService(private val propertyRepository: PropertyRepository) : IPropertyService {
    override fun create(data: Property): Property {
        return this.propertyRepository.save(data)
    }

    override fun findById(id: String): Property {
        return this.propertyRepository.findById(id).orElseThrow { PropertyNotFoundException() }
    }

    override fun findAll(): List<Property> {
        return this.propertyRepository.findAll()
    }

    override fun delete(id: String) {
        val property = this.findById(id)
        this.propertyRepository.delete(property)
    }

    override fun getAvailableProperties(): List<Property> {
        return this.findAll().filter { property -> property.isAvailable }
    }
}
