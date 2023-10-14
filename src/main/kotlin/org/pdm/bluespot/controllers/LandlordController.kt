package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.core.dtos.PropertyCreationDto
import org.pdm.bluespot.core.dtos.users.UserCreationDto
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("landlords")
class LandlordController(private val landlordService: ILandlordService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createLandlord(@RequestBody data: UserCreationDto): Landlord {
        return this.landlordService.create(data.toLandlord())
    }

    @PostMapping("/{id}/properties")
    @ResponseStatus(HttpStatus.CREATED)
    fun addProperty(@PathVariable id: String, @RequestBody data: PropertyCreationDto): Property {
        return this.landlordService.addProperty(id, data.toProperty())
    }

    @GetMapping
    fun findAllLandlord(): List<Landlord> {
        return this.landlordService.findAll()
    }

    @GetMapping("/{id}")
    fun findLandlord(@PathVariable id: String): Landlord {
        return this.landlordService.findById(id)
    }

    @GetMapping("/{id}/properties")
    fun findPropertiesByLandlord(
        @PathVariable id: String,
        @RequestParam available: Boolean?
    ): List<Property> {
        if (available == null) {
            return this.landlordService.listProperties(id)
        }
        return this.landlordService.listProperties(id, available)
    }

    @DeleteMapping("/{id}/properties/{propertyId}")
    fun deleteProperty(@PathVariable id: String, @PathVariable propertyId: String): String {
        this.landlordService.removeProperty(id, propertyId)
        return "Propriedade de id $propertyId retirada com sucesso!"
    }
}