package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `throws an exception when purchase amount is empty string`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("")
        }
    }

    @Test
    fun `throws an exception when purchase amount is blank`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("      ")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not a number`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("ab")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not a positive number`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("-1")
        }

        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("0")
        }
    }
}