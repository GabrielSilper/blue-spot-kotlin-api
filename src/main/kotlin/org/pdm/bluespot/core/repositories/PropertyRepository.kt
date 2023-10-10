package org.pdm.bluespot.core.repositories

import org.pdm.bluespot.core.entities.Property
import org.springframework.data.mongodb.repository.MongoRepository

interface PropertyRepository: MongoRepository<Property, String> {
}