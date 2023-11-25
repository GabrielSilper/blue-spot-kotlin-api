package org.pdm.bluespot.unit.services

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.repositories.PropertyRepository
import org.pdm.bluespot.mocks.mockProperty
import org.pdm.bluespot.mocks.mockResultProperty
import org.pdm.bluespot.services.PropertyService
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PropertyServiceTests {
    private final val propertyRepository: PropertyRepository = mockk()
    private final val propertyService: IPropertyService = PropertyService(propertyRepository)

    @Test
    fun `should create a new property`() {
        //given
        every { propertyRepository.save(mockProperty) } returns mockResultProperty

        //when
        val property = propertyService.createProperty(mockProperty)

        //then
        verify(exactly = 1) { propertyRepository.save(mockProperty) }
        assertEquals(mockResultProperty, property)
    }
}