package lotto.controller


import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val money = inputPurchaseAmount()
        val lottoTickets = generateLottoTickets(money)
        OutputView.printPurchasedTickets(lottoTickets)

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber(winningNumbers)

        val rankCount = LottoRankEvaluator.evaluate(lottoTickets, winningNumbers, bonusNumber)
        OutputView.printWinningStatistics(rankCount)

        val totalPrize = calculateTotalPrize(rankCount)
        val profitRate = ProfitCalculator.calculate(totalPrize, money.value())
        OutputView.printProfitRate(profitRate)
    }

    private fun inputPurchaseAmount(): Money {
        val amount = InputView.readPurchaseAmount()
        return Money(amount)
    }

    private fun generateLottoTickets(money: Money): LottoTickets {
        return LottoGenerator.generateFrom(money)
    }

    private fun inputWinningNumbers(): WinningNumbers {
        val winningNumbersInput = InputView.readWinningNumbers()
        return WinningNumbers.from(winningNumbersInput)
    }

    private fun inputBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        val bonusNumberInput = InputView.readBonusNumber(winningNumbers.getNumbers().map { it.number })
        return BonusNumber(LottoNumber(bonusNumberInput), winningNumbers)
    }

    private fun calculateTotalPrize(rankCount: Map<Rank, Int>): Int {
        return rankCount.entries.sumOf { (rank, count) -> rank.prize * count }
    }
}