package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @Nested
    inner class ValidationTest {
        @ParameterizedTest
        @ValueSource(ints = [150000, 500000, 100001])
        fun `throw when purchase amount input exceed maximum limit`(input: Int) {
            Assertions.assertThatIllegalArgumentException().isThrownBy { PurchaseAmount(input) }
        }

        @ParameterizedTest
        @ValueSource(ints = [10800, 5500, 3115])
        fun `throw when purchase amount is not a valid unit`(input: Int) {
            Assertions.assertThatIllegalArgumentException().isThrownBy { PurchaseAmount(input) }
        }
    }

    @Test
    @DisplayName("[Success] when 3,000 for purchase amount, lottery ticket number is 3")
    fun `calculate number of the lottery ticket safely`() {
        val purchaseAmount = PurchaseAmount(3_000)
        org.junit.jupiter.api.Assertions.assertEquals(purchaseAmount.toTicketNumber(), 3)
    }
}