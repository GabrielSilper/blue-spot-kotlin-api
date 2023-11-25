package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.IPropertyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("properties")
class PropertyController(private val propertyService: IPropertyService) {

    @GetMapping()
    fun getAllProperties() = this.propertyService.getAllProperties()

    @GetMapping("/{id}")
    fun getPropertyById(@PathVariable id: String) = this.propertyService.getPropertyById(id)
}