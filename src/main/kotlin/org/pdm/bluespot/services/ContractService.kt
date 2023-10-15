package org.pdm.bluespot.services

import org.pdm.bluespot.applications.contracts.IContractService
import org.pdm.bluespot.core.entities.Contract
import org.pdm.bluespot.core.exceptions.ContractNotFoundException
import org.pdm.bluespot.core.repositories.ContractRepository
import org.springframework.stereotype.Service

@Service
class ContractService(private val contractRepository: ContractRepository) : IContractService {
    override fun create(data: Contract): Contract {
        return this.contractRepository.save(data)
    }

    override fun findById(contractId: String): Contract {
        return this.contractRepository.findById(contractId)
            .orElseThrow { ContractNotFoundException() }
    }

    override fun delete(contractId: String) {
        val contract = this.findById(contractId)
        this.contractRepository.delete(contract)
    }
}