package lotto.input

import lotto.error.*
import lotto.policy.GamePolicy
import lotto.policy.doesNotOverlapWithWinningNumbers
import lotto.view.InputView
import lotto.view.input.validateBonusNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {

	@Test
	fun `should parse valid winning numbers`() {
		val input = "1, 2, 3, 4, 5, 6"
		assertDoesNotThrow {
			InputView.parseWinningNumbersOrThrow(input)
		}
	}

	@Test
	fun `should throw exception for non-numeric winning number`() {
		val input = "1, 2, a, 4, 5, 6"
		val exception = assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(input)
		}
		assertTrue(exception.message!!.contains(ParseError.INVALID_FORMAT.toMessage()))
	}

	@Test
	fun `should throw exception for duplicated bonus number`() {
		val input = "6"
		val error = validateBonusNumber(input.toInt())
		assertEquals(error.isStatusFailure(), false)
	}

	@Test
	fun `should throw exception for duplicated winning numbers`() {
		val input = "1, 1, 1, 2, 3, 4"
		val exception = assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(input)
		}
		assertTrue(exception.message!!.contains(WinningError.DUPLICATE_NUMBER.toMessage()))
	}

	@Test
	fun `should throw exception for winning number out of range`() {
		val input = "${Int.MAX_VALUE}, 1, 2, 3, 4, 5"
		val exception = assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(input)
		}
		assertTrue(exception.message!!.contains(WinningError.NOT_IN_RANGE.toMessage()))
	}

	@Test
	fun `should throw exception when winning number cannot be parsed as Int`() {
		val input = "${Long.MAX_VALUE}, 1, 2, 3, 4, 5"
		val exception = assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(input)
		}
		assertTrue(exception.message!!.contains(ParseError.INVALID_FORMAT.toMessage()))
	}

	@Test
	fun `should throw exception for bonus number out of range`() {
		val input = "${GamePolicy.LOTTO_MAX_NUMBER + 1}"
		val exception = assertThrows<RetryInputException> {
			InputView.parseBonusNumberOrThrow(input)
		}
		assertTrue(exception.message!!.contains(BonusError.NOT_IN_RANGE.toMessage()))
	}

	@Test
	fun `should throw exception for bonus number duplicated with winning numbers`() {
		val winning = listOf(1, 2, 3, 4, 5, 6)
		val input = "${winning[0]}"
		val exception = assertThrows<RetryInputException> {
			val bonus = InputView.parseBonusNumberOrThrow(input)
			val error = bonus.doesNotOverlapWithWinningNumbers(winning)
			ExceptionHandler.throwIf(error)
		}
		assertTrue(exception.message!!.contains(BonusError.DUPLICATE_NUMBER.toMessage()))
	}
}