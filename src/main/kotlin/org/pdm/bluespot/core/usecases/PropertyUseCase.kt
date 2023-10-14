package org.pdm.bluespot.core.usecases

import org.pdm.bluespot.core.entities.Property

interface PropertyUseCase {
    fun getAvailableProperties(): List<Property>
}
