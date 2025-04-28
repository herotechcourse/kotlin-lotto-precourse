package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val purchaseAmount: Int) {

    fun calculateTicketCount() = purchaseAmount / 1000

    fun generateTickets(ticketCount: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(ticketCount) {
            tickets.add(Lotto(generateRandomNumbers()))
        }
        return tickets
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
    }

    // Prints return rate
    fun printReturnRate(results: List<LottoResult>, ticketCount: Int) {
        val totalWinnings = results.sumOf { it.prize.amount }
        val returnRate = (totalWinnings.toDouble() / (ticketCount * 1000)) * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}