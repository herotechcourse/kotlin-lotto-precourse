package lotto

import lotto.view.ConsoleInputReader
import lotto.view.ConsoleOutputPrinter

fun main() {
    val machine = LottoMachine(ConsoleInputReader(), ConsoleOutputPrinter())
    machine.run()
}
