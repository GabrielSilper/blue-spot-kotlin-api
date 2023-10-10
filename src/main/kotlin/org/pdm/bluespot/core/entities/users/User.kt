package org.pdm.bluespot.core.entities.users

import org.springframework.data.annotation.Id

open class User(
    @Id open var id: String?,
    var name: String,
    var document: String,
    var email: String,
    var password: String
) {
}