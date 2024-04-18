package org.jesperancinha.talks.carparts.carpartsdatascructures.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal
import java.time.Instant


@Table(name = "CAR_PARTS")
@Entity
data class CarPart(
    @Id
    val id: Long,
    @Column
    @field:NotNull
    @field:Size(min=3, max=20)
    val name: String,
    val productionDate: Instant,
    val expiryDate: Instant,
    val barCode: Long,
    @field:Min(value = 5)
    val cost: BigDecimal
)

interface CarPartDao : JpaRepository<CarPart, Long>

