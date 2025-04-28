package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.MAX_NUMBER
import lotto.Constants.MIN_NUMBER
import lotto.Constants.TICKET_PRICE

class LottoMachine (purchaseAmount: Int) {

    val tickets: MutableList<Lotto> = mutableListOf()

    init {
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than zero." }
        require(purchaseAmount % TICKET_PRICE == 0) { "[ERROR] Purchase amount must be divisible by 1000."}
    }

    fun purchaseLottoTicket(purchaseAmount: Int) {
        val ticketQuantity = purchaseAmount / TICKET_PRICE
        repeat (ticketQuantity) {
            val lotto = Lotto(generateTicketNumbers())
            tickets.add(lotto)
        }
    }

    private fun generateTicketNumbers(): List<Int> {
        val ticketNumbers : List<Int> = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6).sorted()
        return ticketNumbers
    }

    fun calculateResults(tickets: List<Lotto>, winningLotto: WinningLotto): Map<ResultRank, Int> {
        val rankCounts = mutableMapOf<ResultRank, Int>()

        tickets.forEach { ticket ->
            val rank = winningLotto.match(ticket)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1

        }
        return rankCounts
    }
}