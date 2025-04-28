package lotto

import camp.nextstep.edu.missionutils.Randoms

class LotteryGame {
    companion object {
        private const val TICKET_COST = 1000  // Cost per ticket in KRW
        private const val MIN_NUMBER = 1     // Minimum possible lottery number
        private const val MAX_NUMBER = 45    // Maximum possible lottery number
        private const val NUMBER_COUNT = 6   // Total numbers per lottery ticket
    }

    // generates all lottery tickets based on the purchase amount
    fun generateAllTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_COST
        return List(ticketCount) {generateLotteryTicket()}
    }

    // returns the number of tickets based on the purchase amount
    fun getTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_COST
    }

    // calculates the lottery prize summary and return rate based on the tickets
    fun calculateLotteryResults(
                          tickets: List<Lotto>,
                          winningNumbers: List<Int>,
                          bonusNumber: Int,
                          purchaseAmount:Int
    ): LotteryPrizeSummary{
        val lotteryResults = LotteryResults()
        val prizeSummary = lotteryResults.calculatePrizeStatistics(tickets, winningNumbers, bonusNumber)
        val returnRate = lotteryResults.calculateReturnRate(purchaseAmount)
        return LotteryPrizeSummary(prizeSummary, returnRate)
    }

    // generates a random lottery ticket with unique numbers
    private fun generateLotteryTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
        return Lotto(numbers)
    }

    // data class to store prize summary and return rate
    data class LotteryPrizeSummary(
        val winningStatuses: List<String>,
        val returnRate: String
    )
}
