package lotto

import lotto.view.OutputView

object InputHandler {

    private const val DEFAULT_ERROR: String = "[ERROR] An unhandled error occurred."

    fun <T> retryOnInvalidInput(input: () -> T): T {
        while (true) {
            try {
                return input()
            } catch (exception: IllegalArgumentException) {
                OutputView.printError(exception.message ?: DEFAULT_ERROR)
            }
        }
    }

}
