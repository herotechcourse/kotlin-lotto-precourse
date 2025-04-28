package lotto.util

import lotto.Lotto
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewKtTest {

    @ParameterizedTest
    @ValueSource(strings = ["1a000", ",,,,", "1,000"])
    fun `throw exception when purchased amount is not numeric`(purchasedAmount: String) {
        assertThrows<IllegalArgumentException> {
            validateNonNumeric(purchasedAmount)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1234, 1230, 1200])
    fun `throw exception when purchased amount is not unit of 1,000`(purchasedAmount: Int) {
        assertThrows<IllegalArgumentException> {
            validateUnitOfAmount(purchasedAmount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["10000000000"])
    fun `throw exception when purchased amount exceeds the range of Integer`(purchasedAmount: String) {
        assertThrows<IllegalArgumentException> {
            validateNumberRange(purchasedAmount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1/2,3,4,5,6", "1,2,3,4.5,6", "1!2@3#4$5%6^"])
    fun `throw exception when winning number not separate by comma`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> {
            validateNonNumericWithoutComma(winningNumbers)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46,])
    fun `throw exception when bonus number is not between 1 and 45`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
             validateRangeOfNumber(bonusNumber)
        }
    }

    @ParameterizedTest
    @MethodSource("winningNumbers")
    fun `throw exception when bonus number contain in winning numbers`(winningNumbers: Lotto) {
        //given
        val bonusNumber = 6

        //then
        assertThrows<IllegalArgumentException> {
            validateDuplicateWithWinningNumbers(winningNumbers, bonusNumber)
        }
    }


    companion object {
        @JvmStatic
        fun winningNumbers(): List<Arguments> = listOf(
            Arguments.arguments(Lotto(listOf(1,2,3,4,5,6))),
            Arguments.arguments(Lotto(listOf(6,40,41,42,43,44)))
        )
    }
}