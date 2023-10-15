package org.pdm.bluespot.applications.contracts

import org.pdm.bluespot.core.entities.Contract

interface IContractService {
    fun create(data: Contract): Contract
    fun findById(contractId: String): Contract
    fun delete(contractId: String)
}
