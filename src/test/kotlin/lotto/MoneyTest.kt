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
        "-1000, Money must be between",
        "2147483001, Money must be between",
        "1500, Money must be divisible by"
    )
    fun `throws exception for invalid amounts`(amount: Int, message: String) {
        // Act
        // Assert
        assertThatThrownBy { Money(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(message)
    }

    @Test
    fun `payFor returns list of items equal to amount divided by 1000`() {
        // Arrange
        val money = Money(2_147_483_000)
        val output = "Lotto"

        // Act
        val result: List<String> = money.payFor { output }

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result).hasSize(2_147_483)
            assertThat(result).containsOnly(output)
        }
    }

    @Test
    fun `fromTicketCount returns correct Money based on ticket count`() {
        // Arrange
        val count = 3

        // Act
        val result: Money = Money.fromTicketCount(count)

        // Assert
        assertThat(result).isEqualTo(Money(1000 * count))
    }

}
