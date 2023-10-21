package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.entities.users.Landlord

interface ILandlordService {
    fun createLandlord(data: Landlord): Landlord
    fun getLandlordById(id: String): Landlord
    fun registerProperty(landlordId: String, property: Property): Property
    fun getLandlordProperties(landlordId: String): List<Property>
}