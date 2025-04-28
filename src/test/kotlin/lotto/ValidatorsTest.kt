/**
 * Test for validators
 */

package lotto

import java.util.stream.Stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class ValidatorsTest {
    private val validator = InputValidator

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidatePurchaseAmountNoExceptionTest")
    fun `validatePurchaseAmount no exception test`(amount: Int) {
        assertDoesNotThrow("Should not throw an exception") { validator.validatePurchaseAmount(amount) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidatePurchaseAmountExceptionTest")
    fun `validatePurchaseAmount exception test`(amount: Int) {
        assertThrows<IllegalArgumentException> { validator.validatePurchaseAmount(amount) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateWinningNumbersNoExceptionTest")
    fun `validateWinningNumbers no exception test`(numbers: List<Int>) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateWinningNumbers(numbers) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateWinningNumbersExceptionTest")
    fun `validateWinningNumbers exception test`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers(numbers) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateBonusNumbersNoExceptionTest")
    fun `validateBonusNumbers no exception test`(numbers: List<Int>, winningNumbers: List<Int>) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateBonusNumbers(numbers, winningNumbers) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateBonusNumbersExceptionTest")
    fun `validateBonusNumbers exception test`(numbers: List<Int>, winningNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> { validator.validateBonusNumbers(numbers, winningNumbers) }
    }

    companion object {
        @JvmStatic
        private fun provideArgumentsForValidatePurchaseAmountNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(const.MIN_AMOUNT),
                Arguments.of(const.MAX_AMOUNT),
                Arguments.of(const.TICKET_PRICE),
                Arguments.of(const.TICKET_PRICE * 2),
                Arguments.of(const.TICKET_PRICE * 10),
                Arguments.of(const.TICKET_PRICE * 100),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidatePurchaseAmountExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(const.MIN_AMOUNT - 1),
                Arguments.of(const.MAX_AMOUNT + 1),
                Arguments.of(const.TICKET_PRICE + 1),
                Arguments.of(const.TICKET_PRICE / 2),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateWinningNumbersNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(2, 4, 6, 8, 10, 12)),
                Arguments.of(listOf(40, 41, 42, 43, 44, 45)),
                Arguments.of(listOf(45, 40, 35, 1, 10, 3)),
                Arguments.of(listOf(30, 21, 35, 8, 11, 5)),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateWinningNumbersExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyList<Int>()),
                Arguments.of(listOf(1, 2, 3)),
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),

                Arguments.of(listOf(0, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 50)),
                Arguments.of(listOf(50, 2, 3, 4, 5, 10)),
                Arguments.of(listOf(1, 2, 3, 50, 5, 10)),

                Arguments.of(listOf(1, 2, 3, 4, 5, 1)),
                Arguments.of(listOf(1, 2, 3, 4, 2, 5)),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateBonusNumbersNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(10), listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(20), listOf(50, 2, 3, 4, 5, 10)),
                Arguments.of(listOf(45), listOf(50, 2, 3, 4, 5, 10)),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateBonusNumbersExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyList<Int>(), listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(10, 20), listOf(1, 2, 3, 4, 5, 6)),

                Arguments.of(listOf(0), listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(50), listOf(1, 2, 3, 4, 5, 6)),

                Arguments.of(listOf(1), listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(6), listOf(1, 2, 3, 4, 5, 6)),
            )
        }
    }
}
