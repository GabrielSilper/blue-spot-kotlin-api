package org.pdm.bluespot.core.entities.users

import org.pdm.bluespot.core.entities.Property
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Landlord(
    id: String?,
    name: String,
    document: String,
    email: String,
    password: String,
    @DBRef
    val properties: MutableList<Property> = ArrayList<Property>()
): User(id, name, document, email, password) {

}