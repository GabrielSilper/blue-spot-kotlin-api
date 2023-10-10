package org.pdm.bluespot.core.repositories.users

import org.pdm.bluespot.core.entities.users.Tenant
import org.springframework.data.mongodb.repository.MongoRepository

interface TenantRepository: MongoRepository<Tenant, String> {
}