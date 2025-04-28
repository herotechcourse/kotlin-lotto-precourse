package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PurchaseTest {

    @Test
    @DisplayName("Valid purchase amount should calculate ticket count correctly")
    fun validPurchase() {
        val purchase = Purchase(5000)
        assertThat(purchase.ticketCount()).isEqualTo(5)
        assertThat(purchase.totalAmount()).isEqualTo(5000)
    }

    @Test
    @DisplayName("Zero or negative amount should throw exception")
    fun invalidZeroOrNegative() {
        assertThatThrownBy { Purchase(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be in multiples of 1,000 KRW.")

        assertThatThrownBy { Purchase(-1000) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be in multiples of 1,000 KRW.")
    }

    @Test
    @DisplayName("Amount not divisible by 1,000 should throw exception")
    fun invalidNotMultipleOfThousand() {
        assertThatThrownBy { Purchase(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be in multiples of 1,000 KRW.")
    }
}
