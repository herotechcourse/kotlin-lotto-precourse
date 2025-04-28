package lotto.view

import lotto.error.*

/**
 * Repeatedly prompts the user for input until a valid value is obtained.
 *
 * 1. Displays the given [prompt] and reads user input.
 * 2. Parses the input using the [reader] function.
 * 3. Validates the parsed value using the optional [validator].
 * 4. If parsing or validation fails, retries by prompting again.
 *
 * @param prompt The message to show when asking for user input.
 * @param reader A function that parses the input string into the desired type [T].
 * @param validator An *optional* validation function for the parsed result. Defaults to no validation.
 * @return A successfully parsed and validated value of type [T].
 *
 * @throws UnexpectedException if an unexpected error occurs during input or parsing.
 */
fun <T> repeatUntilValid(
	prompt: String,
	reader: (String) -> T,
	validator: (T) -> ErrorType = { Common.NON_ERROR }
): T {
	while (true) {
		try {
			return parseInput(readUserInput(prompt), reader)
				.also { validateInput(it, validator) }
		} catch (e: RetryInputException) {
			println(e.message + "\n")
		} catch (e: Exception) {
			throw e
		}
	}
}

/**
 * Reads a line of input from the console by displaying the given [prompt].
 *
 * Internally delegates to [InputView.readLineFromConsole],
 * which reads user input using the console.
 *
 * @param prompt The message shown to the user.
 * @return The input entered by the user as a [String].
 *
 * @throws RetryInputException if input is null.
 */
private fun readUserInput(prompt: String): String {
	return InputView.readLineFromConsole(prompt)
}

private fun <T> parseInput(input: String, reader: (String) -> T): T {
	return reader(input)
}

private fun <T> validateInput(value: T, validator: (T) -> ErrorType) {
	val error = validator(value)
	if (error.isStatusFailure()) {
		throw RetryInputException(error.toMessage())
	}
}
