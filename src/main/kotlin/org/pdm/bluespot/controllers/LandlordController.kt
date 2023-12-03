package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.core.dtos.PropertyCreationDto
import org.pdm.bluespot.core.dtos.UserCreationDto
import org.pdm.bluespot.core.entities.Property
import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/landlords")
class LandlordController(private val landlordService: ILandlordService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createLandlord(@RequestBody data: UserCreationDto): Landlord {
        return landlordService.createLandlord(data.toLandlord())
    }

    @PostMapping("/{landlordId}/properties")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerProperty(
        @PathVariable landlordId: String,
        @RequestBody data: PropertyCreationDto
    ): Property {
        return landlordService.registerProperty(landlordId, data.toProperty())
    }

    @GetMapping("/{landlordId}/properties")
    fun getLandlordProperties(@PathVariable landlordId: String): List<Property> {
        return landlordService.getLandlordProperties(landlordId)
    }
}
