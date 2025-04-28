package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoService {
    companion object {
        private const val TICKET_PRICE = 1000
        private const val LOTTO_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }

    fun createLottoTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = calculateTicketCount(purchaseAmount)
        return generateLottoTickets(ticketCount)
    }

    fun determineRankCounts(tickets: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<Rank, Int> {
        return tickets
            .map { determineRank(it, winningLotto, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    private fun calculateTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_PRICE
    }

    private fun generateLottoTickets(count: Int): List<Lotto> {
        return List(count) { generateLottoTicket() }
    }

    private fun generateLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
        return Lotto(numbers)
    }

    private fun determineRank(ticket: Lotto, winningLotto: Lotto, bonusNumber: Int): Rank {
        val matchCount = ticket.compare(winningLotto)
        val hasBonus = matchCount == 5 && ticket.containsNumber(bonusNumber)
        return Rank.from(matchCount, hasBonus)
    }
} 