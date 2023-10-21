package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.users.Landlord

interface ILandlordService {
    fun createLandlord(data: Landlord): Landlord
}