package org.pdm.bluespot.core.entities.users

import org.pdm.bluespot.core.entities.Contract
import org.pdm.bluespot.core.enums.CivilState
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Tenant(
    id: String?,
    name: String,
    email: String,
    password: String,
    phone: String,
    nationality: String,
    civilState: CivilState,
    occupation: String,
    rg: String,
    cpf: String,
    address: String,
    @DBRef var contract: Contract? = null
) : User(id, name, email, password, phone, nationality, civilState, occupation, rg, cpf, address) {

}