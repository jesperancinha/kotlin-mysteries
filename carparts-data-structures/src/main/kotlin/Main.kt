package org.jesperancinha.talks.carparts

import org.jesperancinha.talks.carparts.carpartsdatascructures.domain.CarPartDao
import org.jesperancinha.talks.carparts.carpartsdatascructures.service.CarPartsService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDateTime
import kotlin.reflect.KProperty

@SpringBootApplication
class CarPartsDataStructureApplication(
    carPartDao: CarPartDao
) {
    @get:Bean("carPartServiceExtended")
    val carPartServiceExtended: CarPartsService by CarPartsService(carPartDao)
}

class LocalDateTimeDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = LocalDateTime.now()
}


fun main(args: Array<String>) {
    runApplication<CarPartsDataStructureApplication>(*args)
}
