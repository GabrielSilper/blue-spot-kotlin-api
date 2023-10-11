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
        val landlord = this.findById(id)

        landlord.name = data.name
        landlord.email = data.email
        landlord.password = data.password
        landlord.phone = data.phone
        landlord.nationality = data.nationality
        landlord.civilState = data.civilState
        landlord.occupation = data.occupation
        landlord.rg = data.rg
        landlord.cpf = data.cpf
        landlord.address = data.address

        return this.landlordRepository.save(landlord)
    }

    override fun delete(id: String) {
        val landlord = this.findById(id)
        this.landlordRepository.delete(landlord)
    }

    @Transactional
    override fun addProperty(landlordId: String, property: Property): Property {
        val landlord = this.findById(landlordId)
        property.landlordId = landlord.id
        val newProperty = this.propertyService.create(property)

        landlord.properties.add(newProperty)
        this.landlordRepository.save(landlord)
        return newProperty
    }

    override fun listProperties(landlordId: String): List<Property> {
        return this.findById(landlordId).properties
    }

    override fun listProperties(landlordId: String, available: Boolean): List<Property> {
        if (available){
            return this.findById(landlordId).properties.filter { property -> property.isAvailable }
        }
        return this.findById(landlordId).properties.filter { property -> !property.isAvailable }
    }

    @Transactional
    override fun removeProperty(landlordId: String, propertyId: String) {
        val landlord = this.findById(landlordId)
        landlord.properties.filter { property -> property.id != propertyId }

        this.propertyService.delete(propertyId)
        this.update(landlordId, landlord)
    }
}