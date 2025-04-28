package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "abc"])
    fun `throws an exception when purchase amount is empty or invalid while Reformatting`(
            input: String
    ) {
        assertThrows<IllegalArgumentException> {
            InputValidator.parseAndValidatePurchaseAmount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1000, 1001])
    fun `throws an exception when purchase amount is less than 0 or not a multiple of 1000 while Validation`(
            input: Int
    ) {
        assertThrows<IllegalArgumentException> { InputValidator.validatePurchaseAmount(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abc", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,a"])
    fun `throws an exception when lotto number input is empty or invalid whlie Reformatting`(
            input: String
    ) {
        assertThrows<IllegalArgumentException> {
            InputValidator.parseAndValidateLottoNumbers(input)
        }
    }

    @Test
    fun `throws an exception when bonus number input is empty or invalid while Reformatting`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.parseAndValidateBonusNumber("", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
        assertThrows<IllegalArgumentException> {
            InputValidator.parseAndValidateBonusNumber("abc", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `throws an exception when bonus number is in winning lotto numbers or not between 1 and 45 while Validation`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(1, winningLotto)
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(0, winningLotto)
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(46, winningLotto)
        }
    }
}
