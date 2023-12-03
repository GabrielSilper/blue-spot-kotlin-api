package org.pdm.bluespot.controllers

import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.core.dtos.LoginDto
import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(private val landlordService: ILandlordService) {

    @PostMapping()
    fun loginLandlord(@RequestBody data: LoginDto): Landlord {
        return landlordService.loginLandlord(data.email, data.password)
    }
}
