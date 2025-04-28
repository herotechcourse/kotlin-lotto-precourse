package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val money = Money(amount)

    val lottoTickets = LottoGenerator.generateFrom(money)
//    println("You have purchased ${lottoTickets.size()} tickets.")
//    println(lottoTickets)
    OutputView.printPurchasedTickets(lottoTickets)

    val winningNumbersInput = InputView.readWinningNumbers()
    val winningNumbers = WinningNumbers.from(winningNumbersInput)

    val bonusNumberInput = InputView.readBonusNumber(winningNumbersInput)
    val bonusNumber = BonusNumber(LottoNumber(bonusNumberInput), winningNumbers)

    val rankCount = LottoRankEvaluator.evaluate(lottoTickets, winningNumbers, bonusNumber)
    OutputView.printWinningStatistics(rankCount)

    val totalPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize * count }
    val profitRate = ProfitCalculator.calculate(totalPrize, money.value())
    OutputView.printProfitRate(profitRate)
}