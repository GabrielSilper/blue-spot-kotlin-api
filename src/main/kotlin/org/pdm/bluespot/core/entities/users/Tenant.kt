package org.pdm.bluespot.core.entities.users

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Tenant(
    id: String?,
    name: String,
    document: String,
    email: String,
    password: String
) : User(id, name, document, email, password) {

}