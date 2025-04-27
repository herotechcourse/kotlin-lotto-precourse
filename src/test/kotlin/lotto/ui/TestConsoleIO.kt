package lotto.ui

class TestConsoleIO(private val inputStrings: MutableList<String> = mutableListOf()) : ConsoleIoInterface {
    private var inputIndex = 0
    val outputMessages = mutableListOf<String>()

    override fun read(): String {
        if (inputIndex < inputStrings.size) {
            return inputStrings[inputIndex++]
        } else {
            throw IllegalStateException("No more input available for testing.")
        }
    }

    override fun print(message: String) {
        outputMessages.add(message)
    }
}