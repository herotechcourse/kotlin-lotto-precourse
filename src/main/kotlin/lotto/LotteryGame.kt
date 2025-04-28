package lotto

import camp.nextstep.edu.missionutils.Randoms

class LotteryGame {
    companion object {
        private const val TICKET_COST = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBER_COUNT = 6
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
        val prizeSummary = lotteryResults.calculatePrizeStatistics(tickets, winningNumbers, bonusNumber)
        val returnRate = lotteryResults.calculateReturnRate(purchaseAmount)
        return LotteryResults(prizeSummary, returnRate)
    }

    private fun generateLotteryTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
        return Lotto(numbers)
    }

    data class LotteryResults(
        val winningStatuses: List<String>,
        val returnRate: String
    )
}
