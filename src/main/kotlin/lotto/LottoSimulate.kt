package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoSimulate() {
    private var amount: Int
    private var winningNumbers: List<Int>
    private var bonusNumber: Int

    private var lottoCount: Int
    private var lottoList: MutableList<Lotto> = mutableListOf()

    init {
        amount = InputView.getPurchaseAmount()

        lottoCount = amount / 1000

        for (i in 1..lottoCount) {
            lottoList.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()))
        }

        OutputView.displayTickets(lottoList)

        winningNumbers = InputView.getWinningNumbers()
        bonusNumber = InputView.getBonusNumber(winningNumbers)

        val matchedNumber: Array<Int> = countMatched(lottoList, winningNumbers, bonusNumber)
        val returnRate: Double = calReturnRate(amount, matchedNumber)

        OutputView.displayWinningStatistics(matchedNumber, returnRate)
    }

    fun countMatched(lottoList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Array<Int> {
        val matchedList = Array(6) { 0 }

        for (lotto in lottoList) {
            val prize = lotto.calculatePrize(winningNumbers, bonusNumber)
            matchedList[prize.index]++
        }

        return matchedList
    }

    fun calReturnRate (amount: Int, matchedNumber: Array<Int>): Double {
        var totalPrize: Double = 0.0

        for (prize in Prize.entries) {
            totalPrize += matchedNumber[prize.index] * prize.amount
        }

        return totalPrize / amount * 100
    }
}