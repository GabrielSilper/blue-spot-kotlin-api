package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.users.Tenant

interface ITenantService {
    fun create(data: Tenant): Tenant
    fun findById(id: String): Tenant
    fun findAll(): List<Tenant>
    fun update(id: String, data: Tenant): Tenant
    fun delete(id: String)
}