package lotto.input

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.error.RetryInputException
import lotto.error.WinningError
import lotto.error.isStatusFailure
import lotto.error.toMessage
import lotto.policy.GamePolicy
import lotto.policy.doesNotOverlapWithWinningNumbers
import lotto.view.InputView
import lotto.view.repeatUntilValid
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputUtilsTest : NsTest() {

	@Test
	fun `valid winning numbers input should pass without exception`() {
		assertSimpleTest {
			assertDoesNotThrow {
				InputView.parseWinningNumbersOrThrow(VALID_WINNING_NUMBERS)
			}
		}
	}

	@Test
	fun `should throw error on winning numbers with duplicate`() {
		assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(INVALID_WINNING_NUMBERS_DUPLICATE)
		}
	}

	@Test
	fun `should retry on RetryInputException and return on valid input`() {
		assertSimpleTest {
			run(INVALID_WINNING_NUMBERS_DUPLICATE, VALID_WINNING_NUMBERS)
			var callCount = 0
			val result = repeatUntilValid(
				prompt = GamePolicy.WINNING_MESSAGE,
				reader = {
					callCount++
					InputView.parseWinningNumbersOrThrow(it)
				}
			)
			assertThat(callCount).isEqualTo(2)
			assertThat(output()).contains(WinningError.DUPLICATE_NUMBER.toMessage())
			assertThat(result).containsExactlyElementsOf(
				VALID_WINNING_NUMBERS.split(",").map { it.trim().toInt() }
			)
		}
	}

	@Test
	fun `valid purchase amount input should pass without exception`() {
		assertDoesNotThrow {
			run(VALID_PURCHASE_AMOUNT)
			repeatUntilValid(
				prompt = GamePolicy.AMOUNT_MESSAGE,
				reader = {
					InputView.parseAmountOrThrow(it)
				}
			)
		}
	}


	@Test
	fun `should throw error on purchase amount under ticket price`() {
		assertThrows<RetryInputException> {
			InputView.parseAmountOrThrow(INVALID_PURCHASE_AMOUNT_UNDER_TICKET_PRICE)
		}
	}

	@Test
	fun `should throw error on purchase amount not divisible by ticket price`() {
		assertThrows<RetryInputException> {
			InputView.parseAmountOrThrow(INVALID_PURCHASE_AMOUNT_NOT_DIVISIBLE)
		}
	}


	@Test
	fun `should throw error on bonus number out of valid range`() {
		assertThrows<RetryInputException> {
			InputView.parseBonusNumberOrThrow(INVALID_BONUS_NUMBER_OUT_OF_RANGE)
		}
	}

	@Test
	fun `should throw error on purchase amount zero`() {
		assertThrows<RetryInputException> {
			InputView.parseAmountOrThrow(INVALID_PURCHASE_AMOUNT_ZERO)
		}
	}

	@Test
	fun `should throw error on winning numbers out of range`() {
		assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(INVALID_WINNING_NUMBERS_OUT_OF_RANGE)
		}
	}

	@Test
	fun `should throw error on winning numbers wrong size`() {
		assertThrows<RetryInputException> {
			InputView.parseWinningNumbersOrThrow(INVALID_WINNING_NUMBERS_WRONG_SIZE)
		}
	}

	@Test
	fun `should throw error on bonus number duplicate with winning numbers`() {
		val winningNumbers: List<Int> = VALID_WINNING_NUMBERS
			.split(",")
			.map { it.trim().toInt() }
		val bonusNumber = InputView.parseBonusNumberOrThrow(winningNumbers[0].toString())
		val errorType = bonusNumber.doesNotOverlapWithWinningNumbers(winningNumbers)
		assertThat(errorType.isStatusFailure()).isTrue()
	}

	override fun runMain() {}

	companion object {
		// Valid Inputs
		private const val VALID_PURCHASE_AMOUNT = "14000"
		private const val VALID_WINNING_NUMBERS = "1,2,3,4,5,6"

		// Invalid - Purchase Amount
		private const val INVALID_PURCHASE_AMOUNT_NOT_DIVISIBLE = "13500"
		private const val INVALID_PURCHASE_AMOUNT_UNDER_TICKET_PRICE = "999"
		private const val INVALID_PURCHASE_AMOUNT_ZERO = "0"

		// Invalid - Winning Numbers
		private const val INVALID_WINNING_NUMBERS_DUPLICATE = "1,1,2,3,4,5"
		private const val INVALID_WINNING_NUMBERS_OUT_OF_RANGE = "0,2,3,4,5,6"
		private const val INVALID_WINNING_NUMBERS_WRONG_SIZE = "1,2,3,4,5"

		// Invalid - Bonus Number
		private const val INVALID_BONUS_NUMBER_OUT_OF_RANGE = "46"
	}
}