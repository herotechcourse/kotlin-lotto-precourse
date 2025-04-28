package lotto

import lotto.validators.InputValidator

class Prompter<T>(
        private val inputView: InputView,
        private val promptMessage: String,
        private val validator: InputValidator<T>
) {
    fun prompt(): T {
        while (true) {
            try {
                inputView.showPrompt(promptMessage)
                val input = inputView.readInput()
                val validatedInput = validator.validate(input)
                println("${input}\n")
                return validatedInput
            } catch (e: IllegalArgumentException) {
                inputView.showError(e.message ?: "Invalid input")
            }
        }
    }
}
