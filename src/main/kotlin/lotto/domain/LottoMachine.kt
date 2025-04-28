package lotto.domain

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
