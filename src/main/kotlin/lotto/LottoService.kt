package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoService {
    private val TICKET_PRICE = 1000

    fun createLottoTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_PRICE
        return List(ticketCount) { generateLottoTicket() }
    }

    private fun generateLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun determineRankCounts(tickets: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<Rank, Int> {
        return tickets.map { determineRank(it, winningLotto, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    private fun determineRank(ticket: Lotto, winningLotto: Lotto, bonusNumber: Int): Rank {
        val matchCount = ticket.compare(winningLotto)
        val hasBonus = ticket.containsNumber(bonusNumber)
        return Rank.from(matchCount, hasBonus)
    }
} 