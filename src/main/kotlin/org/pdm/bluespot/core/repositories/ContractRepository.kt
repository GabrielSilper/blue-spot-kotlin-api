package org.pdm.bluespot.core.repositories

import org.pdm.bluespot.core.entities.Contract
import org.springframework.data.mongodb.repository.MongoRepository

interface ContractRepository: MongoRepository<Contract, String> {

}