import  lotto.service.LottoService
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy


class LottoServiceTest {
    @Nested
    @DisplayName("validatePurchaseAmount() Test")
    inner class ValidatePurchaseAmountTest {
        @ParameterizedTest
        @ValueSource(ints = [1000, 3000, 10000, 35000])
        @DisplayName("Should pass when amount is positive number divisible by 1000")
        fun validAmount(amount: Int) {
            LottoService.validatePurchaseAmount(amount)
        }

        @ParameterizedTest
        @ValueSource(ints = [0, -1, -1000])
        @DisplayName("Should throw when amount is zero or negative")
        fun invalidZeroOrNegativeAmount(amount: Int) {
            assertThatThrownBy { LottoService.validatePurchaseAmount(amount) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid amount: $amount. The purchase amount must be a positive number and divisible by 1,000 KRW.")
        }

        @ParameterizedTest
        @ValueSource(ints = [10, 1100, 3001])
        @DisplayName("Should throw when amount is not divisible by 1000")
        fun invalidNonDivisibleAmount(amount: Int) {
            assertThatThrownBy { LottoService.validatePurchaseAmount(amount) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid amount: $amount. The purchase amount must be a positive number and divisible by 1,000 KRW.")
        }
    }

    @Nested
    @DisplayName("generateTickets() Test")
    inner class GenerateTicketsTest {
        @ParameterizedTest
        @ValueSource(ints = [6, 12, 32])
        @DisplayName("Should generate the correct number of tickets")
        fun generateCorrectNumberTickets(amount: Int) {
            val tickets = LottoService.generateTickets(amount)
            assertThat(tickets).hasSize(amount)
        }

        @Test
        @DisplayName("Should generate a six unique numbers ticket in the range of 1 .. 45")
        fun eachTicketIsValid() {
            val tickets = LottoService.generateTickets(50)

            tickets.forEach { lotto ->
                val numbers = lotto.getNumbers()
                assertThat(numbers)
                    .hasSize(6)
                    .doesNotHaveDuplicates()
                    .allMatch { it in 1..45 }
            }
        }
    }
}