package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.users.Tenant

interface ITenantService {
    fun createTenant(data: Tenant): Tenant
    fun getAllTenants(): List<Tenant>
}