package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPurchaseTetst {
    @Test
    fun `throws an exception when amount can't divisible by 1,000 KRW`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase(1200)
        }
    }
}
