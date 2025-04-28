package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class PurchaseAmountTest {

    @Test
    fun `valid amount creates instance`() {
        val pa = PurchaseAmount(5000)
        assertThat(pa.ticketCount()).isEqualTo(5)
    }

    @Test
    fun `amount less than 1000 throws exception`() {
        assertThatThrownBy { PurchaseAmount(500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be at least 1,000 KRW and divisible by 1,000.")
    }

    @Test
    fun `amount not divisible by 1000 throws exception`() {
        assertThatThrownBy { PurchaseAmount(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be at least 1,000 KRW and divisible by 1,000.")
    }
}