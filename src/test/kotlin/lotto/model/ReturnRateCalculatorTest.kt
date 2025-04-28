package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ReturnRateCalculatorTest {
    @ParameterizedTest
    @CsvSource("1000, 2000, 200.0", "2000, 1000, 50.0")
    fun `should calculate return rate based on purchase and winning amount`(purchaseAmount: Int, winningAmount: Int, expectedReturnRate: Double) {
        val result = ReturnRateCalculator.run(purchaseAmount, winningAmount)

        assertThat(result).isEqualTo(expectedReturnRate)
    }
}

