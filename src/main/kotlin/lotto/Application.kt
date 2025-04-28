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

    val winningNumbers = WinningNumbers.from(InputView.readWinningNumbers())

    val bonusNumberInput = InputView.readBonusNumber(winningNumbers.getNumbers().map { it.number })
    val bonusNumber = BonusNumber(LottoNumber(bonusNumberInput), winningNumbers)

    val result = LottoRankEvaluator.evaluate(lottoTickets, winningNumbers, bonusNumber)

    OutputView.printWinningStatistics(result)

    val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
    val profitRate = ProfitCalculator.calculate(totalPrize, money.value())
    OutputView.printProfitRate(profitRate)
}