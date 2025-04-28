package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.error.*
import lotto.util.validateOrThrow
import lotto.view.input.*

object InputView {
	/**
	 * If true, InputView will use FakeConsole for input instead of actual Console.readLine()
	 * Used *only* in testing environment to simulate user input.
	 * @see [FakeConsole]
	 */
	var useFakeInput: Boolean = false

	fun parseWinningNumbersOrThrow(input: String): List<Int> =
		parseAndValidate(input, ::parseWinningNumbers, ::validateWinningNumbers)

	fun parseBonusNumberOrThrow(input: String): Int =
		parseAndValidate(input, ::parseBonusNumber, ::validateBonusNumber)

	fun parseAmountOrThrow(input: String): Long =
		parseAndValidate(input, ::parseAmountOrNull, ::validateAmount)

	fun readLineFromConsole(prompt: String): String {
		println(prompt)
		return (if (useFakeInput) FakeConsole.readLine() else Console.readLine())
			?: throw RetryInputException(ParseError.NULL_FOUND.toMessage())
	}

	/**
	 * Parses the input string and validates the parsed result.
	 *
	 * @param input the raw user input string
	 * @param parse a function to parse the input into type T
	 * @param validate a function to validate the parsed result
	 * @return the successfully parsed and validated value of type T
	 * @throws RetryInputException if parsing fails or validation fails
	 */
	private fun <T> parseAndValidate(
		input: String,
		parse: (String) -> T?,
		validate: (T) -> ErrorType,
	): T {
		val notNullInput = input.validateOrThrow {
			@Suppress("ConstantConditionIf")
			if (it == null) ParseError.NULL_FOUND else Common.NON_ERROR
		}
		val parsed = parse(notNullInput)
			?: throw RetryInputException(ParseError.INVALID_FORMAT.toMessage())
		parsed.validateOrThrow(validate)
		return parsed
	}
}
