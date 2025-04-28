package lotto.view

object OutputView {
    private const val ERROR_HEAD = "[ERROR]"

    fun printError(message: String) {
        println("$ERROR_HEAD $message\n")
    }
}