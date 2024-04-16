package org.jesperancinha.talks.carparts

import java.lang.reflect.Field
import java.math.BigDecimal
import java.time.Instant

fun main() {
    val carPartDto = CarPartDto(
        id = 123L,
        name = "name",
        productionDate = Instant.now(),
        expiryDate = Instant.now(),
        cost = BigDecimal.TEN,
        barCode = 1234L
    )
    println(carPartDto)
    val field: Field = CarPartDto::class.java
        .getDeclaredField("name")
    field.isAccessible = true
    field.set(carPartDto, null)
    println(carPartDto)
    assert(carPartDto.name == null)
    println(carPartDto.name == null)

//    carPartDto.name = null
//    val carPartDto2 = CarPartDto(
//        id = 123L,
//        name = null,
//        productionDate = Instant.now(),
//        expiryDate = Instant.now(),
//        cost = BigDecimal.TEN,
//        barCode = 1234L
//    )
}