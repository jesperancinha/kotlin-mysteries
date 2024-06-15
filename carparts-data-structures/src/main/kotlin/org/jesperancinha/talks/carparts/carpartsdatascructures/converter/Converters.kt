package org.jesperancinha.talks.carparts.carpartsdatascructures.converter

import org.jesperancinha.talks.carparts.carpartsdatascructures.converter.Converters.logger
import org.jesperancinha.talks.carparts.carpartsdatascructures.domain.CarPart
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsdatascructures.utils.getLogger
import org.slf4j.Logger

object Converters {
    val logger: Logger = getLogger<Converters>()
}

fun CarPart.toDto() =
    CarPartDto(
        id = id,
        name = name,
        productionDate = productionDate,
        expiryDate = expiryDate,
        barCode = barCode,
        cost = cost
    ).also { logger.info("Tried to convert data {}", it) }

fun CarPartDto.toEntity() = CarPart(
    id = id,
    name = name,
    productionDate = productionDate,
    expiryDate = expiryDate,
    barCode = barCode,
    cost = cost
)