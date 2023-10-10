package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.exceptions.PropertyNotFound
import org.pdm.bluespot.core.repositories.PropertyRepository
import org.springframework.stereotype.Service

@Service
class PropertyService(private val propertyRepository: PropertyRepository) : IPropertyService {
    override fun create(data: Property): Property {
        return this.propertyRepository.save(data)
    }

    override fun findById(id: String): Property {
        return this.propertyRepository.findById(id).orElseThrow { PropertyNotFound() }
    }

    override fun findAll(): List<Property> {
        return this.propertyRepository.findAll()
    }

    override fun update(id: String, data: Property): Property {
        val optionalProperty = this.propertyRepository.findById(id)

        if (optionalProperty.isEmpty) throw PropertyNotFound()

        optionalProperty.get().address = data.address
        optionalProperty.get().price = data.price

        return this.propertyRepository.save(optionalProperty.get())
    }

    override fun delete(id: String) {
        val optionalProperty = this.propertyRepository.findById(id)

        if (optionalProperty.isEmpty) throw PropertyNotFound()

        this.propertyRepository.delete(optionalProperty.get())
    }
}
