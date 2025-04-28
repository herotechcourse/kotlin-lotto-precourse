package lotto

internal inline fun <T> InputView.validateWithReprompt(
    readAction: InputView.() -> String,
    validation: (String) -> T,
    outputView: OutputView
): T {
    while (true) {
        try {
            return validation(readAction())
        } catch (e: IllegalArgumentException) {
            outputView.error(e.message!!)
        }
    }
}