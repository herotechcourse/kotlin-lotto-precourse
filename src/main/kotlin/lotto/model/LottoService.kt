package lotto.model

import lotto.Lotto
import lotto.util.LottoConstants

class LottoService() {

    private var lottoTickets: List<Lotto> = emptyList()
    private var winnerNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = -1

    fun purchaseTickets(amount: Int) {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = amount / LottoConstants.TICKET_PRICE
        val tickets = List(numberOfTickets) {
            lottoGenerator.createLottoTicket()
        }
        setTickets(tickets)
    }

    fun setTickets(tickets: List<Lotto>) {
        lottoTickets = tickets
    }

    fun getTickets(): List<Lotto> {
        return lottoTickets
    }

    fun setWinnerNumbers(numbers: List<Int>) {
        winnerNumbers = numbers
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = number
    }

    fun getWinnerNumbers(): List<Int> {
        return winnerNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }

    fun compareTickets(): MutableMap<Rank, Int> {
        val rankCounts = initializeRankCounts()
        countRanks(rankCounts)
        return rankCounts
    }

    private fun initializeRankCounts(): MutableMap<Rank, Int> {
        val rankCounts = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            rankCounts[rank] = 0
        }
        return rankCounts
    }

    private fun countRanks(rankCounts: MutableMap<Rank, Int>) {
        lottoTickets.forEach { ticket ->
            val hits = ticket.countHits(winnerNumbers)
            val hasBonus = ticket.containsBonus(bonusNumber)
            val rank = Rank.from(hits, hasBonus)
            rankCounts[rank] = rankCounts.getValue(rank) + 1
        }
    }

    fun calculateReturnRate(rankList: Map<Rank, Int>, purchaseAmount: Int): Double {
        val totalWinnings = rankList.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        return totalWinnings / purchaseAmount * 100
    }
}