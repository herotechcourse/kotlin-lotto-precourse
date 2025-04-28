package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoPurchaseTest {
    @Test
    fun `create valid lotto purchase`() {
        val purchase = LottoPurchase.from(1000)
        assertEquals(1, purchase.ticketCount)
    }

    @Test
    fun `create multiple lotto tickets`() {
        val purchase = LottoPurchase.from(5000)
        assertEquals(5, purchase.ticketCount)
    }

    @Test
    fun `throw exception when amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase.from(1500)
        }
    }

    @Test
    fun `toString returns tickets as string`() {
        val purchase = LottoPurchase.from(1000)
        assert(purchase.toString().startsWith("["))
    }
} 