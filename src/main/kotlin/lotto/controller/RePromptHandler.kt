package lotto.controller

object RePromptHandler {
    fun <T> run(inputAction: () -> T): T {
        while (true) {
            try {
                return inputAction()
            } catch (e: IllegalArgumentException) {
                print(e.message)
                println(" Please enter again.")
            }
        }
    }
}