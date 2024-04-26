package org.jesperancinha.talks.carparts

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `should find total weight of all cars`() {
        totalWeight(findAllCars()) shouldBe 4120.0
    }
}