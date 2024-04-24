package org.jesperancinha.talks.carparts.carpartsdatascructures.domain

import io.kotest.assertions.throwables.shouldThrow
import org.jesperancinha.talks.carparts.carpartsmanager.ContainerTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.TransactionSystemException
import java.math.BigDecimal
import java.time.Instant

@SpringBootTest
class CarPartDaoTest @Autowired constructor(
    val carPartDao: CarPartDao
) : ContainerTest(
) {

    @Test
    fun `should fail while creating an invalid entity`() {
        shouldThrow<TransactionSystemException> {
            carPartDao.save(
                CarPart(
                    id = 0,
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
        carPartDao.save(
            CarPart(
                id = 0,
                name = "Bolt",
                productionDate = Instant.now(),
                expiryDate = Instant.now(),
                barCode = 1001L,
                cost = BigDecimal.TEN
            )
        )
    }
}