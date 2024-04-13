package org.jesperancinha.talks.carparts.carpartsmanager.converter

import org.jesperancinha.talks.carparts.carpartsmanager.converter.Converters.logger
import org.jesperancinha.talks.carparts.carpartsmanager.domain.CarPart
import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsmanager.utils.getLogger
import org.slf4j.Logger

object Converters {
    val logger: Logger = getLogger<Converters>()
}

fun CarPart.toDto() = try {
    CarPartDto(
        id = id,
        name = name,
        productionDate = productionDate,
        expiryDate = expiryDate,
        barCode = barCode,
        cost = cost
    )
} catch (ex: Exception) {
    logger.error("Failed to convert data!", ex)
    null
} finally {
    logger.info("Tried to convert data {}", this)
}

fun CarPartDto.toEntity() = CarPart(
    id = id,
    name = name,
    productionDate = productionDate,
    expiryDate = expiryDate,
    barCode = barCode,
    cost = cost
)