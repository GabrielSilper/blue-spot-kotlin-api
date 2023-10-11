package org.pdm.bluespot.core.entities.users

import org.pdm.bluespot.core.enums.CivilState
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed


open class User(
    @Id open var id: String?,
    var name: String,
    @Indexed(unique = true) var email: String,
    var password: String,
    @Indexed(unique = true) var phone: String,
    var nationality: String,
    var civilState: CivilState,
    var occupation: String,
    @Indexed(unique = true) var rg: String,
    @Indexed(unique = true) var cpf: String,
    var address: String
) {
}