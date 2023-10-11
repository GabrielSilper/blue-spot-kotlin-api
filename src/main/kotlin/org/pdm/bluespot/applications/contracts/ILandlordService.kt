package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.users.Landlord
import org.pdm.bluespot.core.usecases.LandlordUseCase


interface ILandlordService : LandlordUseCase {
    fun create(data: Landlord): Landlord
    fun findById(id: String): Landlord
    fun findAll(): List<Landlord>
    fun update(id: String, data: Landlord): Landlord
    fun delete(id: String)
}