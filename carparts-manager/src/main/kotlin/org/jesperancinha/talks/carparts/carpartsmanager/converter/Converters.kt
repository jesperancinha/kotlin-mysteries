package org.jesperancinha.talks.carparts.carpartsmanager.converter

import org.jesperancinha.talks.carparts.carpartsmanager.domain.CarPart
import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto

fun CarPart.toDto() = CarPartDto(
    id = id,
    name = name,
    productionDate = productionDate,
    expiryDate = expiryDate,
    barCode = barCode,
    cost = cost
)

fun CarPartDto.toEntity() = CarPart(
    id = id,
    name = name,
    productionDate = productionDate,
    expiryDate = expiryDate,
    barCode = barCode,
    cost = cost
)