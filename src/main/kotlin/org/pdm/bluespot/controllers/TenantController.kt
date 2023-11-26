package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.ITenantService
import org.pdm.bluespot.core.dtos.UserCreationDto
import org.pdm.bluespot.core.entities.users.Tenant
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("tenants")
class TenantController(private val tenantService: ITenantService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTenant(@RequestBody data: UserCreationDto): Tenant {
        return tenantService.createTenant(data.toTenant())
    }

    @GetMapping
    fun getAllTenants(): List<Tenant> {
        return tenantService.getAllTenants()
    }
}