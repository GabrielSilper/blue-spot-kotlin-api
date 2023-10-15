package org.pdm.bluespot.core.usecases

import org.pdm.bluespot.core.entities.Contract

interface TenantUseCase {
    fun signContract(tenantId: String, propertyId: String, months: Long): Contract
    fun finishContract(contractId: String)
    fun viewContract(contractId: String): Contract
}