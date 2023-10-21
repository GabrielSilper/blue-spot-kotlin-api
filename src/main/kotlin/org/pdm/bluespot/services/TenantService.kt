package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.ITenantService
import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.core.repositories.users.TenantRepository
import org.springframework.stereotype.Service

@Service
class TenantService(private val tenantRepository: TenantRepository): ITenantService{
    override fun createTenant(data: Tenant): Tenant {
        return this.tenantRepository.save(data)
    }
}