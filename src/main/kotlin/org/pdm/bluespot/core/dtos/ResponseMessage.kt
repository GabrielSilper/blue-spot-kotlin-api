package org.pdm.bluespot.core.dtos

data class ResponseMessage<T>(val message: String, val data: T)
