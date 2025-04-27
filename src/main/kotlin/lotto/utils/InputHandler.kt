package lotto.utils

import lotto.view.ErrorView

fun <T> getValidatedInput(
    prompt: String,
    readInput: (String) -> String,
    validate: (String) -> T
): T {
    val errorView = ErrorView()
    while (true) {
        val input = readInput(prompt)
        try {
            return validate(input)
        } catch (e: IllegalArgumentException) {
            e.message?.let { errorView.printError(it) }
        }
    }
}