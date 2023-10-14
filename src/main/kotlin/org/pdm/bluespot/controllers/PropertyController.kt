package org.pdm.bluespot.controllers

import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.services.PropertyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("properties")
class PropertyController(private val propertyService: PropertyService) {

    @GetMapping
    fun findAllPropertiesAvailable(): List<Property> {
        return this.propertyService.getAvailableProperties()
    }
}