package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.core.entities.users.Landlord

import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.core.repositories.users.LandlordRepository

class LandlordService(private val landlordRepository: LandlordRepository): ILandlordService{
    override fun createLandlord(data: Landlord): Landlord {
        return this.landlordRepository.save(data)
    }
}