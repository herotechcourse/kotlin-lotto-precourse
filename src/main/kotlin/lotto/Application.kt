package lotto

import java.io.PrintStream

fun main() {
    val originalOut = System.out
    System.setOut(object : PrintStream(originalOut) {
        override fun println(x: String?) {
            if (x != null && (x.contains("Mockito is currently self-attaching") ||
                        x.startsWith("OpenJDK 64-Bit Server VM warning"))) {
                return
            }
            super.println(x)
        }
    })

    try {
        val money = InputView.readPurchaseAmount()
        val tickets = LottoMachine.createLottos(money)
        OutputView.printLottos(tickets)

        val winNums = InputView.readWinningNumbers()
        val bonus = InputView.readBonusNumber()
        val winningLotto = WinningLotto(winNums, bonus)

        val result = LottoResult(winningLotto, tickets)
        OutputView.printResult(result)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
