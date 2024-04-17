package org.jesperancinha.talks.carparts.carpartsdatascructures.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal
import java.time.Instant


@Table(name = "CAR_PARTS")
@Entity
data class CarPart(
    @Id
    val id: Long,
    val name: String,
    val productionDate: Instant,
    val expiryDate: Instant,
    val barCode: Long,
    val cost: BigDecimal
)

interface CarPartDao : JpaRepository<CarPart, Long>

