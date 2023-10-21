package org.pdm.bluespot.core.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
class Contract(
    @Id var id: String?,
    var tenantId: String,
    var property: Property,
    var startDate: LocalDate,
    var endDate: LocalDate
) {
}