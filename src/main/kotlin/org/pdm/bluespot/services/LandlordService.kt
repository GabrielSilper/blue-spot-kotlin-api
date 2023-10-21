package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.entities.users.Landlord

import org.pdm.bluespot.core.exceptions.LandlordNotFoundException
import org.pdm.bluespot.core.repositories.users.LandlordRepository

class LandlordService(
    private val landlordRepository: LandlordRepository,
    private val propertyService: IPropertyService
) : ILandlordService {
    override fun createLandlord(data: Landlord): Landlord {
        return this.landlordRepository.save(data)
    }

    override fun getLandlordById(id: String): Landlord {
        return this.landlordRepository.findById(id).orElseThrow { LandlordNotFoundException() }
    }

    override fun registerProperty(landlordId: String, property: Property): Property {
        val landlord = this.getLandlordById(landlordId)
        val newProperty = this.propertyService.createProperty(property)

        landlord.properties.add(newProperty)
        this.landlordRepository.save(landlord)

        return newProperty
    }

    override fun getLandlordProperties(landlordId: String): List<Property> {
        return this.getLandlordById(landlordId).properties
    }
}