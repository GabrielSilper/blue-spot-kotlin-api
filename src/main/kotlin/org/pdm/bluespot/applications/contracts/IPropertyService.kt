package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Property

interface IPropertyService {
    fun createProperty(): Property
}