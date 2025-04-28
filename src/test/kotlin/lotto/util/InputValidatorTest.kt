package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @ParameterizedTest
    @ValueSource(strings = ["1000", "8000", "100000"])
    fun `should parse valid amount`(amountString: String) {
        val amount = inputValidator.validateAndParseAmount(amountString)
        assertThat(amount).isEqualTo(amountString.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1000j", " ", "500", "-1000", "0"])
    fun `amount with invalid format should throw exception`(amountString: String) {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateAndParseAmount(amountString)
        }
        assertThat(exception.message).contains("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,5,3,4,6", "1, 2, 3, 4, 5, 6"])
    fun `should parse valid winning numbers`(amountString: String) {
        val numbers = inputValidator.validateAndParseWinningNums(amountString)
        assertThat(numbers).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
        assertThat(numbers).hasSize(6)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,2,2,3,4",
                             "0,1,2,3,4,5", "44,45,46,47,48,49", "a,1,2,3,4,5,"])
    fun `invalid winning numbers should throw exception`(amountString: String) {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateAndParseWinningNums(amountString)
        }
        assertThat(exception.message).contains("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "a", "49", "0"])
    fun `invalid bonus number should throw exception`(amountString: String) {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateAndParseBonusNum(amountString)
        }
        assertThat(exception.message).contains("[ERROR]")
    }
}