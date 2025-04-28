package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PurchaseAmountTest {

    @Test
    fun `should create PurchaseAmount successfully when amount is multiple of 1000`() {
        val purchaseAmount = PurchaseAmount(5000)
        assertThat(purchaseAmount.getNumberOfTickets()).isEqualTo(5)
    }

    @Test
    fun `should throw exception if amount is not multiple of 1000`() {
        assertThatThrownBy { PurchaseAmount(5500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Amount must be a multiple of 1000")
    }

    @Test
    fun `should correctly calculate number of tickets`() {
        val purchaseAmount = PurchaseAmount(3000)
        val numberOfTickets = purchaseAmount.getNumberOfTickets()
        assertThat(numberOfTickets).isEqualTo(3)
    }

    @Test
    fun `should correctly calculate percentage of total prize`() {
        val purchaseAmount = PurchaseAmount(5000)
        val percentage = purchaseAmount.percentageOf(2500)
        assertThat(percentage).isEqualTo(BigDecimal("50"))
    }
}