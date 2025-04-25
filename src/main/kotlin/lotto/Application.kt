package lotto

import lotto.domain.*
import lotto.view.InputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val money = Money(amount)

    val lottoTickets = LottoGenerator.generateFrom(money)
    println("You have purchased ${lottoTickets.size()} tickets.")
    println(lottoTickets)

    val winningNumbers = WinningNumbers.from(InputView.readWinningNumbers())
    val bonusNumber = BonusNumber(LottoNumber(InputView.readBonusNumber(winningNumbers.getNumbers().map { it.number })), winningNumbers)

    val result = LottoRankEvaluator.evaluate(lottoTickets, winningNumbers, bonusNumber)

}