package lotto

import lotto.TicketChecker.addStatistics

fun main() {
    // 1. purchase lotto
    val purchaseAmount = InputView.purchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val myLotto = mutableListOf<Lotto>()
    for (i in 0 until ticketCount) {
        myLotto.add(LottoGenerator.generateLotto())
    }

    // 2. winning lotto input
    val winningLotto = Lotto(InputView.winningNum())
    val bonusNumber = InputView.bonusNum()

    // 3. lotto statistics
    myLotto.forEach { lotto ->
        addStatistics(lotto, winningLotto, bonusNumber)
    }

    OutputView.myLotto(myLotto)
    OutputView.resultStatistics()
    OutputView.profitRate(ProfitRateCalaulator.calculateProfitRate(purchaseAmount))


}
