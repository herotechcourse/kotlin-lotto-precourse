package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame {

    fun play() {
        val tickets = purchaseLottoTickets()
        val winningLotto = createWinningLotto()

        val rankResult = winningLotto.getMultipleLottoRanks(tickets)
        val profitRate = calculateProfitRateInPercentage(rankResult)

        //TODO: output ranks
        //TODO: output statics

    }

    fun purchaseLottoTickets(): List<Lotto> {
        val amountOfPurchase = InputView.inputAmountOfPurchase()
        val tickets = createLottoTickets(amountOfPurchase)
        //TODO: output purchased tickets
        return tickets
    }

    fun createWinningLotto(): WinningLotto {
        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)

        return WinningLotto(winningNumbers, bonusNumber)
    }


    fun createLottoTickets(amount: Int): List<Lotto> {
        if (amount <= 0) throw IllegalArgumentException("[Error] Amount must be greater than 0")

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
        val formattedProfitRate = String.format("%.1f%%", profitRate)

        return formattedProfitRate
    }
}
