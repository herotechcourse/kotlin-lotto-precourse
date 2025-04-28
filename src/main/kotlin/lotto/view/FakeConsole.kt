package lotto.view

/**
 * Fake console input provider for testing purposes only.
 * @see [InputView]
 * This object simulates user input by returning prepared values
 * instead of reading from the real console.
 */
object FakeConsole {
	private val inputs = mutableListOf<String>()

	fun prepare(vararg values: String) {
		inputs.clear()
		inputs.addAll(values)
	}

	fun readLine(): String {
		if (inputs.isEmpty()) throw NoSuchElementException("No more input prepared")
		return inputs.removeFirst()
	}
}