package org.jesperancinha.talks.carparts.carpartsdatascructures.service

import io.kotest.assertions.throwables.shouldThrow
import jakarta.validation.ConstraintViolationException
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsmanager.ContainerTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.TransactionSystemException
import java.math.BigDecimal
import java.time.Instant

@SpringBootTest
class CarPartsServiceTest @Autowired constructor(val carPartsService: CarPartsService) : ContainerTest() {
    @Test
    fun `should fail while creating an invalid entity`() {
        shouldThrow<TransactionSystemException> {
            carPartsService.createCarPart(
                CarPartDto(
                    name = "Bolt",
                    productionDate = Instant.now(),
                    expiryDate = Instant.now(),
                    barCode = 1001L,
                    cost = BigDecimal.ONE
                )
            )
        }
    }

    @Test
    fun `should create a valid entity`() {
        carPartsService.createCarPart(
            CarPartDto(
                name = "Bolt",
                productionDate = Instant.now(),
                expiryDate = Instant.now(),
                barCode = 1001L,
                cost = BigDecimal.TEN
            )
        )
    }
}