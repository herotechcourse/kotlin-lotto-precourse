package lotto

import lotto.view.ConsoleInputReader
import lotto.view.ConsoleOutputPrinter

fun main() {
    val machine = Lotto(ConsoleInputReader(), ConsoleOutputPrinter())
    machine.run()
}
