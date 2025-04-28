package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("500")
        }

        assertThrows<IllegalArgumentException> {
            PurchaseAmount.from("1001")
        }
    }

    @Test
    fun `calculate possible lotto ticket count based on purchase amount`() {
        assertThat(PurchaseAmount(1000).possibleLottoTicketCount).isEqualTo(1)
        assertThat(PurchaseAmount(5000).possibleLottoTicketCount).isEqualTo(5)
    }
}