package org.pdm.bluespot.unit.services

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.pdm.bluespot.applications.contracts.ILandlordService
import org.pdm.bluespot.applications.contracts.IPropertyService
import org.pdm.bluespot.core.repositories.PropertyRepository
import org.pdm.bluespot.core.repositories.users.LandlordRepository
import org.pdm.bluespot.mocks.*
import org.pdm.bluespot.services.LandlordService
import org.pdm.bluespot.services.PropertyService
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class LandlordServiceTests(
) {

    private final val landlordRepository: LandlordRepository = mockk()
    private final val propertyRepository: PropertyRepository = mockk()
    private final val propertyService: IPropertyService = PropertyService(propertyRepository)
    private final val landlordService: ILandlordService =
        LandlordService(landlordRepository, propertyService)

    @Test
    fun `should create a new landlord`() {
        //given
        every { landlordRepository.save(any()) } returns mockResultLandlord

        //when
        val landlord = landlordService.createLandlord(mockLandlord)

        //then
        verify(exactly = 1) { landlordRepository.save(any()) }
        assertEquals(mockResultLandlord, landlord)
    }

    @Test
    fun `should provide a specific landlord`() {
        //given
        every { landlordRepository.findById("123") } returns Optional.of(mockResultLandlord)

        //when
        val landlord = landlordService.getLandlordById("123")

        //then
        verify(exactly = 1) { landlordRepository.findById("123") }
        assertEquals(mockResultLandlord, landlord)
    }

    @Test
    fun `should register a new property for a landlord`() {
        //given
        every { propertyService.createProperty(mockProperty) } returns mockResultAddProperty
        every { landlordService.getLandlordById("653352ad7d213c17a1d0fc5e") } returns mockResultLandlord
        mockResultLandlord.properties.add(mockResultAddProperty)
        every { landlordRepository.save(any()) } returns mockResultLandlord

        //when
        val property = landlordService.registerProperty("653352ad7d213c17a1d0fc5e", mockProperty)

        //then
        verify(exactly = 1) { propertyService.createProperty(mockProperty) }
        verify(exactly = 1) { landlordRepository.findById("653352ad7d213c17a1d0fc5e") }
        verify(exactly = 1) { landlordRepository.save(any()) }
        assertEquals(mockResultAddProperty, property)
    }

    @Test
    fun `should provide all properties of a landlord`() {
        //given
        every { landlordService.getLandlordById("653352ad7d213c17a1d0fc5e") } returns mockLandlordWithProperties

        //when
        val properties = landlordService.getLandlordProperties("653352ad7d213c17a1d0fc5e")

        //then
        verify(exactly = 1) { landlordService.getLandlordById("653352ad7d213c17a1d0fc5e") }
        assertEquals(mockLandlordWithProperties.properties, properties)
    }
}