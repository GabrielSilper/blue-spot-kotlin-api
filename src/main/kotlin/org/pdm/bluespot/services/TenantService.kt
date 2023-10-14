package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.ITenantService
import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.core.exceptions.TenantNotFound
import org.pdm.bluespot.core.repositories.users.TenantRepository
import org.springframework.stereotype.Service

@Service
class TenantService(private val tenantRepository: TenantRepository) : ITenantService {
    override fun create(data: Tenant): Tenant {
        return this.tenantRepository.save(data)
    }

    override fun findById(id: String): Tenant {
        return this.tenantRepository.findById(id).orElseThrow{ TenantNotFound() }
    }

    override fun findAll(): List<Tenant> {
        return this.tenantRepository.findAll()
    }

    override fun update(id: String, data: Tenant): Tenant {
        val tenant = this.findById(id)

        tenant.name = data.name
        tenant.email = data.email
        tenant.password = data.password
        tenant.phone = data.phone
        tenant.nationality = data.nationality
        tenant.civilState = data.civilState
        tenant.occupation = data.occupation
        tenant.rg = data.rg
        tenant.cpf = data.cpf
        tenant.address = data.address

        return this.tenantRepository.save(tenant)
    }

    override fun delete(id: String) {
        val tenant = this.findById(id)
        this.tenantRepository.delete(tenant)
    }

}