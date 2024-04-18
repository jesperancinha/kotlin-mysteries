package org.jesperancinha.talks.carparts.carpartsdatascructures.dto

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Positive
import java.math.BigDecimal
import java.time.Instant

data class CarPartDto(
    val id: Long = 0,
    val name: String,
    val productionDate: Instant,
    val expiryDate: Instant,
    @field:Positive
    @field:DecimalMin(value = "1000")
    val barCode: Long,
    @field:Positive
    @field:DecimalMin(value = "5")
    val cost: BigDecimal
)