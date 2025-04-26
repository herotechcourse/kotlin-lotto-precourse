package lotto

fun main() {
    val machine = LottoMachine(ConsoleInputReader(), ConsoleOutputPrinter())
    machine.run()
}
