package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.entities.users.Landlord
import org.pdm.bluespot.core.exceptions.LandlordNotFoundException
import org.pdm.bluespot.core.repositories.users.LandlordRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LandlordService(
    private val landlordRepository: LandlordRepository,
    private val propertyService: IPropertyService
) : ILandlordService {
    override fun create(data: Landlord): Landlord {
        return this.landlordRepository.save(data)
    }

    override fun findById(id: String): Landlord {
        val landlord = this.landlordRepository.findById(id)
        return landlord.orElseThrow { LandlordNotFoundException() }
    }

    override fun findAll(): List<Landlord> {
        return this.landlordRepository.findAll()
    }

    override fun update(id: String, data: Landlord): Landlord {
        val landlord = this.landlordRepository.findById(id)

        if (landlord.isEmpty) throw LandlordNotFoundException()

        landlord.get().name = data.name
        landlord.get().document = data.document
        landlord.get().email = data.email
        landlord.get().password = data.password

        return this.landlordRepository.save(landlord.get())
    }

    override fun delete(id: String) {
        val landlord = this.landlordRepository.findById(id)

        if (landlord.isEmpty) throw LandlordNotFoundException()

        this.landlordRepository.delete(landlord.get())
    }

    @Transactional
    override fun addProperty(landlordId: String, property: Property): Property {
        val landlord = this.findById(landlordId)
        val newProperty = this.propertyService.create(property)

        landlord.properties.add(newProperty)
        this.landlordRepository.save(landlord)
        return newProperty
    }

    override fun listProperties(landlordId: String): List<Property> {
        return this.findById(landlordId).properties
    }

    @Transactional
    override fun removeProperty(landlordId: String, propertyId: String) {
        val landlord = this.findById(landlordId)
        landlord.properties.filter { property -> property.id != propertyId }

        this.propertyService.delete(propertyId)
        this.update(landlordId, landlord)
    }
}