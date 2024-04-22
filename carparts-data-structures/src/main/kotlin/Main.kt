package org.jesperancinha.talks.carparts

import jakarta.validation.constraints.NotNull
import org.jesperancinha.talks.carparts.carpartsdatascructures.domain.CarPartDao
import org.jesperancinha.talks.carparts.carpartsdatascructures.service.CarPartsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CarPartsDataStructureApplication(
    carPartDao: CarPartDao
) {
    @delegate:NotNull
    @get:Bean("carPartServiceExtended")
    val carPartServiceExtended: CarPartsService? by CarPartsService(carPartDao)
}

fun main(args: Array<String>) {
    runApplication<CarPartsDataStructureApplication>(*args)
}
