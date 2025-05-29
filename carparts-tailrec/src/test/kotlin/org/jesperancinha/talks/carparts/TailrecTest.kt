package org.jesperancinha.talks.carparts

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TailrecTest {


   internal tailrec fun factorial(n: Int): Int {
        return if (n == 0) 1 else n * factorial(n - 1)
    }

    @Test
    fun `should test classic recursion`() {
        factorial(3) shouldBe 6
    }
}