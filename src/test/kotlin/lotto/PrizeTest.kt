package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeTest {

    @ParameterizedTest
    @CsvSource(
        "-1000, Prize must not be negative.",
        "1500, Prize must be divisible by"
    )
    fun `should throw exception for invalid amounts`(amount: Long, message: String) {
        // Arrange
        assertThatThrownBy { Prize(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(message)
    }

    @Test
    fun `plus operator should return correct sum`() {
        // Arrange
        val amount1 = 1_000L
        val amount2 = 2_000L

        // Act
        val result: Prize = Prize(amount1) + Prize(amount2)

        // Assert
        assertThat(result).isEqualTo(Prize(amount1 + amount2))
    }

    @Test
    fun `times operator should return correct product`() {
        // Arrange
        val amount = 5_000L
        val times = 3

        // Act
        val result: Prize = Prize(amount) * times

        // Assert
        assertThat(result).isEqualTo(Prize(amount * times))
    }

    @Test
    fun `div operator should return correct ratio`() {
        // Arrange
        val prizeAmount = 4_000L
        val moneyAmount = 2_000

        // Act
        val ratio: Double = Prize(prizeAmount) / Money(moneyAmount)

        // Assert
        assertThat(ratio).isEqualTo((prizeAmount.toDouble()) / moneyAmount)
    }

    @Test
    fun `compareTo should return correct comparison result`() {
        // Arrange
        val prize1 = Prize(1_000L)
        val prize2 = Prize(2_000L)

        // Act
        // Assert
        SoftAssertions.assertSoftly {
            assertThat(prize1 < prize2).isTrue()
            assertThat(prize1 > prize2).isFalse()
        }
    }

    @Test
    fun `ZERO should equal Prize with 0`() {
        // Arrange
        val prizeZero = Prize(0L)

        // Act
        val zero = Prize.ZERO

        // Assert
        assertThat(zero).isEqualTo(prizeZero)
    }
}
