package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputReader
import lotto.view.ConsoleOutputPrinter

fun main() {
    val consoleInputReader = ConsoleInputReader()
    val consoleOutputPrinter = ConsoleOutputPrinter()

    try {
        val lottoController = LottoController(consoleInputReader, consoleOutputPrinter)
        lottoController.run()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] " + e.message)
    } catch (e: Exception) {
        println("[ERROR] Unexpected error")
    }

    consoleOutputPrinter.close()
}
