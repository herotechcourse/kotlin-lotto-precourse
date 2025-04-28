package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputReader
import lotto.view.ConsoleOutputPrinter

fun main() {
    val lottoController = LottoController(ConsoleInputReader(), ConsoleOutputPrinter())
    lottoController.run()
}
