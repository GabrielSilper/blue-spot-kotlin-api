package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.core.dtos.ResponseMessage
import org.pdm.bluespot.core.dtos.UserCreationDto
import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.http.HttpStatus
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
    fun createLandlord(@RequestBody data: UserCreationDto): ResponseMessage<Landlord> {
        val newLandlord = this.landlordService.createLandlord(data.toLandlord())
        val message = "Landlord created successfully"
        return ResponseMessage(message, newLandlord)
    }

}
