package lotto.utils

import lotto.view.ErrorView

fun <T> getValidatedInput(
    prompt: String,
    readInput: (String) -> String,
    validate: (String) -> T
): T {
    val errorView = ErrorView()
    while (true) {
        val input  = readInput(prompt)
        val result = runValidation(input, validate, errorView)
        if (result != null) return result
    }
}

private fun <T> runValidation(
    input: String,
    validate: (String) -> T,
    errorView: ErrorView
): T? = try {
    validate(input)
} catch (e: IllegalArgumentException) {
    e.message?.let { errorView.printError(it) }
    null
}