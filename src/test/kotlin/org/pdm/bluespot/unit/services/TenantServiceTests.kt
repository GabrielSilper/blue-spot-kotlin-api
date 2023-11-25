package org.pdm.bluespot.unit.services

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.pdm.bluespot.applications.contracts.ITenantService
import org.pdm.bluespot.core.repositories.users.TenantRepository
import org.pdm.bluespot.mocks.mockResultTenant
import org.pdm.bluespot.mocks.mockTenant
import org.pdm.bluespot.services.TenantService
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TenantServiceTests {
    private val tenantRepository: TenantRepository = mockk()
    private val tenantService: ITenantService = TenantService(tenantRepository)

    @Test
    fun `should create a new tenant`() {
        //given
        every { tenantRepository.save(mockTenant) } returns mockResultTenant
        //when
        val tenant = tenantService.createTenant(mockTenant)
        //then
        verify(exactly = 1) { tenantRepository.save(mockTenant) }
        assertEquals(mockResultTenant, tenant)
    }
}