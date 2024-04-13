package org.jesperancinha.talks.carparts.carpartsmanager.dto

import java.math.BigDecimal
import java.time.Instant

data class CarPartDto(
    val id: Long,
    val name: String,
    val productionDate: Instant,
    val expiryDate: Instant,
    val barCode: Long,
    val cost: BigDecimal
)