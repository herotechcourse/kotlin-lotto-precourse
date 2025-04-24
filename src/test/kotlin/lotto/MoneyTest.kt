package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MoneyTest {

    @ParameterizedTest
    @CsvSource(
        "-1000, Money must not be negative.",
        "1500, Money must be divisible by",
    )
    fun `throws exception for invalid amounts`(amount: Long, message: String) {
        // Act
        // Assert
        assertThatThrownBy { Money(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(message)
    }

    @ParameterizedTest
    @CsvSource("0, true", "2000, false")
    fun `isZero returns boolean`(amount: Long, expected: Boolean) {
        // Arrange
        val money = Money(amount)

        //act
        val isZero = money.isZero()

        // Assert
        assertThat(isZero).isEqualTo(expected)
    }

    @Test
    fun `payFor returns list of items equal to amount divided by 1000`() {
        // Arrange
        val money = Money(3000)
        val output = "Lotto"

        // Act
        val result = money.payFor { output }

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result).hasSize(3)
            assertThat(result).containsOnly(output)
        }
    }

    @Test
    fun `div returns correct ratio between two Money instances`() {
        // Arrange
        val totalPrize = Money(5000)
        val cost = Money(2000)

        // Act
        val ratio: Double = totalPrize / cost

        // Assert
        assertThat(ratio).isEqualTo(2.5)
    }


    @Test
    fun `fromTicketCount returns correct Money based on ticket count`() {
        // Arrange
        val count = 3

        // Act
        val result: Money = Money.fromTicketCount(count)

        // Assert
        assertThat(result).isEqualTo(Money(1000L * count))
    }

}
