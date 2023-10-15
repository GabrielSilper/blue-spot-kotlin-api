package org.pdm.bluespot.controllers

import org.pdm.bluespot.core.dtos.ContractCreationDto
import org.pdm.bluespot.core.dtos.users.UserCreationDto
import org.pdm.bluespot.core.entities.Contract
import org.pdm.bluespot.core.entities.users.Tenant
import org.pdm.bluespot.services.TenantService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tenants")
class TenantController(private val tenantService: TenantService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTenant(@RequestBody data: UserCreationDto): Tenant {
        return this.tenantService.create(data.toTenant())
    }

    @PostMapping("/{tenantId}/contract/{propertyId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun signContract(
        @PathVariable tenantId: String,
        @PathVariable propertyId: String,
        @RequestBody data: ContractCreationDto
    ): Contract {
        return this.tenantService.signContract(tenantId, propertyId, data.months)
    }

    @GetMapping
    fun findAllTenants(): List<Tenant> {
        return this.tenantService.findAll()
    }

    @GetMapping("/{id}")
    fun findTenantById(@PathVariable id: String): Tenant {
        return this.tenantService.findById(id)
    }
}