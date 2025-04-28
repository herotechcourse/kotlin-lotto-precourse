package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = ["abc", "1000.5", "", " "])
    fun `throws an exception when input string is not a valid integer`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 1500, 2999])
    fun `throws an exception when purchase amount is not positive or not a multiple of 1000`(amount: Int) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(amount)
        }
    }

    @Test
    fun `calculate ticket count correctly`() {
        val purchaseAmount = PurchaseAmount(5000)
        assertEquals(5, purchaseAmount.ticketCount)
    }

    @Test
    fun `getPurchaseAmount returns the original purchase amount`() {
        val purchaseAmount = PurchaseAmount(3000)
        assertEquals(3000, purchaseAmount.getPurchaseAmount())
    }

    @Test
    fun `from creates PurchaseAmount from valid string`() {
        val purchaseAmount = PurchaseAmount.from("4000")
        assertEquals(4, purchaseAmount.ticketCount)
    }
}
