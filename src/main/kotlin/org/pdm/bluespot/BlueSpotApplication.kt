package org.pdm.bluespot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlueSpotApplication

fun main(args: Array<String>) {
	runApplication<BlueSpotApplication>(*args)
}
