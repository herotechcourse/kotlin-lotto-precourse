package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.util.*

class LottoGame {

    fun play() {
        val tickets = purchaseLottoTickets()
        val winningLotto = createWinningLotto()

        val rankResult = winningLotto.getMultipleLottoRanks(tickets)
        val countRanks = countRanks(rankResult)
        val profitRate = calculateProfitRateInPercentage(rankResult)

        OutputView.printResultStatistics(countRanks, profitRate)
    }

    fun purchaseLottoTickets(): List<Lotto> {
        val amountOfPurchase = InputView.inputAmountOfPurchase()
        val tickets = createLottoTickets(amountOfPurchase)
        OutputView.printPurchasedTickets(amountOfPurchase, tickets)
        return tickets
    }

    fun createWinningLotto(): WinningLotto {
        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)

        return WinningLotto(winningNumbers, bonusNumber)
    }


    fun createLottoTickets(amount: Int): List<Lotto> {
        if (amount <= 0) throw IllegalArgumentException("[ERROR] Amount must be greater than 0")

        val tickets = mutableListOf<Lotto>()
        repeat(amount) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            tickets.add(lotto)
        }
        return tickets
    }

    fun countRanks(ranks: List<LottoRank>): Map<LottoRank, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun calculateProfitRateInPercentage(rankResult: List<LottoRank>): String {
        val cost = rankResult.size * 1_000

        val sumOfPrize = countRanks(rankResult).map { (rank, count) ->
            rank.prize * count
        }.sum()

        val profitRate = sumOfPrize.toDouble() / cost * 100
        val formattedProfitRate = String.format(Locale.KOREA, "%.1f%%", profitRate)

        return formattedProfitRate
    }
}
