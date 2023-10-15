package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.IContractService
import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.applications.contracts.ITenantService
import org.pdm.bluespot.core.entities.Contract
import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.core.exceptions.TenantNotFoundException
import org.pdm.bluespot.core.repositories.users.TenantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class TenantService(
    private val tenantRepository: TenantRepository,
    private val contractService: IContractService,
    private val propertyService: IPropertyService
) : ITenantService {
    override fun create(data: Tenant): Tenant {
        return this.tenantRepository.save(data)
    }

    override fun findById(id: String): Tenant {
        return this.tenantRepository.findById(id).orElseThrow { TenantNotFoundException() }
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

    @Transactional
    override fun signContract(tenantId: String, propertyId: String, months: Long): Contract {
        val tenant = this.findById(tenantId)
        val property = this.propertyService.findById(propertyId)

        val contract = Contract(
            null,
                tenantId,
                property,
                LocalDate.now(),
                LocalDate.now().plusMonths(months)
        )

        val newContract = this.contractService.create(contract);
        tenant.contract = newContract
        property.isAvailable = false

        this.propertyService.update(propertyId, property)
        this.tenantRepository.save(tenant)
        return newContract
    }

    override fun finishContract(contractId: String) {
        val contract = this.contractService.findById(contractId)
        val tenant = this.findById(contract.tenantId)

        tenant.contract = null
        this.tenantRepository.save(tenant)
        this.contractService.delete(contractId)
    }

    override fun viewContract(contractId: String): Contract {
        return this.contractService.findById(contractId)
    }
}