package org.jesperancinha.talks.carparts.carpartsmanager

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class ContainerTest {
	companion object {

		private val postgreSQLContainer
				by lazy {
					PostgreSQLContainer<Nothing>("postgres:15")
						.also { it.start() }
				}

		@DynamicPropertySource
		@JvmStatic
		@SuppressWarnings("unused")
		fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
			registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
			registry.add("spring.datasource.username", postgreSQLContainer::getUsername)
			registry.add("spring.datasource.password", postgreSQLContainer::getPassword)
		}
	}
}
