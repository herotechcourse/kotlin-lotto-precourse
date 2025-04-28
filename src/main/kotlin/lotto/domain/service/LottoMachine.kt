package lotto.domain.service

import lotto.domain.model.Lotties
import lotto.domain.model.Money
import lotto.domain.model.WinningNumbers

class LottoMachine(
    private val lottoGenerator: LottoGenerator,
    private val resultCalculator: ResultCalculator = ResultCalculator(),
    private val money: Money
) {

    fun createWinningNumbers(winningNumber: List<Int>, bonusNumber: Int): WinningNumbers {
        return WinningNumbersFactory().create(winningNumber, bonusNumber)
    }

    fun issueLotties(): Lotties {
        return lottoGenerator.generateLotties(money.ticketCount)
    }

    fun calculateResult(lotties: Lotties, winningNumbers: WinningNumbers): WinResult {
        return resultCalculator.calculateTotalMatch(lotties, winningNumbers)
    }
}
