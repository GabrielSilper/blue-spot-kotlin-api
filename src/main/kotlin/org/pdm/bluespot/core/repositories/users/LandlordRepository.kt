package org.pdm.bluespot.core.repositories.users

import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.data.mongodb.repository.MongoRepository

interface LandlordRepository: MongoRepository<Landlord, String> {
}