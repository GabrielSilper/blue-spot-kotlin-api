package org.pdm.bluespot.controllers

import org.pdm.bluespot.core.dtos.ErrorMessage
import org.pdm.bluespot.core.exceptions.LandlordNotFoundException
import org.pdm.bluespot.core.exceptions.LandlordUnauthorizedException
import org.pdm.bluespot.core.exceptions.PropertyNotFoundException
import org.pdm.bluespot.core.exceptions.TenantNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler
    fun notFoundExceptionHandler(e: LandlordNotFoundException): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.NOT_FOUND.value(), e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message)
    }

    @ExceptionHandler
    fun notFoundExceptionHandler(e: PropertyNotFoundException): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.NOT_FOUND.value(), e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message)
    }

    @ExceptionHandler
    fun notFoundExceptionHandler(e: TenantNotFoundException): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.NOT_FOUND.value(), e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message)
    }

    @ExceptionHandler
    fun unauthorizedExceptionHandler(e: LandlordUnauthorizedException): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.UNAUTHORIZED.value(), e.message)
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message)
    }

    @ExceptionHandler
    fun generalExceptionHandler(e: Exception): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message)
    }
}