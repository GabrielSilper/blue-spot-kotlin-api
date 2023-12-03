package org.pdm.bluespot.core.repositories.users

import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface LandlordRepository: MongoRepository<Landlord, String> {
    fun findByEmailAndPassword(email: String, password: String): Optional<Landlord>
}