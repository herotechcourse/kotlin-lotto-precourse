package lotto

import lotto.TicketChecker.addStatistics

fun main() {
    val purchaseAmount = InputView.purchaseAmount()
    val winningLotto = Lotto(InputView.winningNum())
    val bonusNumber = InputView.bonusNum()
    val ticketCount = purchaseAmount/1000

    val myLotto = mutableListOf<Lotto>()
    for ( i in 0 until ticketCount) {
        myLotto.add(LottoGenerator.generateLotto())
    }

    myLotto.forEach{ lotto ->
        addStatistics( lotto, winningLotto, bonusNumber)
    }

    OutputView.myLotto(myLotto)
    OutputView.resultStatistics()
    OutputView.profitRate(ProfitRateCalaulator.calculateProfitRate(purchaseAmount))







}
