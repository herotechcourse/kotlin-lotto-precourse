package lotto

import lotto.domain.LottoMachine
import lotto.domain.ResultCalculator
import lotto.view.InputView;
import lotto.view.OutputView
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

fun main() {
  val purchaseAmount = InputView.readPurchaseAmount();
  val count = purchaseAmount/1000
  val tickets = LottoMachine().issu(count)
  OutputView.printTickets(tickets)

  val winningNumbers = InputView.readWinningNumbers()
  val bonusNumber = InputView.readBonusNumber(winningNumbers)

  val stats = ResultCalculator(winningNumbers, bonusNumber).calculate(tickets)

  OutputView.printResult(stats, purchaseAmount)

}

private fun <T> tryRead(block:()->T):T=
  try{
    block()
  }catch (e:IllegalArgumentException){
    println(e.message)
    tryRead(block)
  }