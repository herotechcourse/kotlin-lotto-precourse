package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputReader
import lotto.view.ConsoleOutputPrinter

fun main() {
    try {
        val lottoController = LottoController(ConsoleInputReader(), ConsoleOutputPrinter())
        lottoController.run()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] " + e.message)
    } catch (e: Exception) {
        println("[ERROR] Unexpected error")
    }
}
