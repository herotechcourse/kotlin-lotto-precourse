package lotto.controller

object RePromptHandler {
    fun <T> run(inputAction: () -> T): T {
        while (true) {
            try {
                return inputAction()
            } catch (e: IllegalArgumentException) {
                println("${e.message} Please enter again.")
            }
        }
    }
}