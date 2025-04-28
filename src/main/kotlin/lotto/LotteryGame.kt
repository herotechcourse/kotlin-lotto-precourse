package lotto

import camp.nextstep.edu.missionutils.Randoms

class LotteryGame {
    companion object {
        private const val TICKET_COST = 1000
    }

    fun generateAllTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_COST
        return List(ticketCount) {generateLotteryTicket()}
    }

    fun getTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_COST
    }

    fun getLotteryResults(
                          tickets: List<Lotto>,
                          winningNumbers: List<Int>,
                          bonusNumber: Int,
                          purchaseAmount:Int
    ): LotteryResults{
        val lotteryResults = LotteryResults()
        val winningStatuses = lotteryResults.getStatistics(tickets, winningNumbers, bonusNumber)
        val returnRate = lotteryResults.calculateReturnRate(purchaseAmount)
        return LotteryResults(winningStatuses, returnRate)
    }

    private fun generateLotteryTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    data class LotteryResults(
        val winningStatuses: List<String>,
        val returnRate: String
    )
}
