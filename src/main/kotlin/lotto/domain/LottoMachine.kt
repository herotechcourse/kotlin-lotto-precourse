package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoMachine {

    private lateinit var winningDraw: WinningDraw

    fun buyTickets(player: Player) {
        val moneySpent = InputView.getPayment()
        val ticketCount = moneySpent / Settings.TICKET_PRICE
        val lottoTickets: List<Lotto> = List(ticketCount) { createTicket() }
        player.moneySpent = moneySpent
        player.lottoTickets = lottoTickets
        OutputView.showPurchase(lottoTickets.map { it.getNumbers() })
    }

    fun submitWinningData() {
        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber(winningNumbers)
        winningDraw = WinningDraw(winningNumbers, bonusNumber)
    }

    fun showWinningStats(player: Player) {
        val rankResults = Calculator.getRankDetails(player, winningDraw)
        player.prizeSum = Calculator.calculateRankEarnings(rankResults)
        player.returnRate = Calculator.calculateProfitRate(player.moneySpent, player.prizeSum)
        OutputView.printStats(rankResults, player.returnRate)
    }

    companion object {
        fun createTicket(): Lotto {
            val numbers =
                Randoms.pickUniqueNumbersInRange(Settings.MIN_RANGE, Settings.MAX_RANGE, Settings.TICKET_LEN).sorted()
            return Lotto(numbers)
        }
    }
}

object Calculator {
    fun getRankDetails(player: Player, winningDraw: WinningDraw): Map<LottoRank, Pair<Int, Int>> {
        val rankingTable = mutableMapOf<LottoRank, Pair<Int, Int>>()
        for (rank in LottoRank.entries) {
            rankingTable[rank] = Pair(0, rank.prizeMoney)
        }
        for (ticket in player.lottoTickets) {
            rankTicket(ticket, winningDraw, rankingTable)
        }
        return rankingTable
    }

    private fun rankTicket(
        ticket: Lotto,
        winningDraw: WinningDraw,
        rankingTable: MutableMap<LottoRank, Pair<Int, Int>>
    ) {
        val ticketRank = winningDraw.match(ticket)
        if (ticketRank != null) {
            val (matchingTickets, prizeMoney) = rankingTable.getOrDefault(ticketRank, Pair(0, ticketRank.prizeMoney))
            rankingTable[ticketRank] = Pair(matchingTickets + 1, prizeMoney)
        }
    }

    fun calculateRankEarnings(lottoRankResults: Map<LottoRank, Pair<Int, Int>>): Int {
        var totalEarned = 0
        for ((ticketCount, prizeMoney) in lottoRankResults.values) {
            totalEarned += ticketCount * prizeMoney
        }
        return totalEarned
    }

    fun calculateProfitRate(moneySpent: Int, totalPrize: Int): Double {
        if (moneySpent == 0) return 0.0
        return (totalPrize.toDouble() / moneySpent) * 100
    }
}