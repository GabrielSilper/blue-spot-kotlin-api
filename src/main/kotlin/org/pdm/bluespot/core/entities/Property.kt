package org.pdm.bluespot.core.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.pdm.bluespot.core.entities.users.Landlord
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Property(
    @Id var id: String?,
    var address: String,
    var price: Double,
    var restrictions: MutableList<String> = ArrayList<String>(),
    var furnishings: MutableList<String> = ArrayList<String>(),
) {
}