package org.jesperancinha.talks.carparts.carpartsmanager.domain

import io.kotest.matchers.collections.shouldHaveSize
import org.jesperancinha.talks.carparts.carpartsmanager.ContainerTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DomainTest @Autowired constructor(
    private val carPartDao: CarPartDao,
) : ContainerTest() {

    @Test
    fun `should mysteriously get a list with a car part with a name null`() {
        // For illustration purposes only.
        // It DOES receive a null value.
        carPartDao.findAll()
            .filter {
                it.name == null
            }
            .shouldHaveSize(1)
    }
}