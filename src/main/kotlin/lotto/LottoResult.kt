package lotto

import lotto.constants.Prizes

class LottoResult {
    var winningStatistics: MutableMap<String, Int> = mutableMapOf()
        private set
    var returnRate: Double = 0.0
        private set

    init {
        this.winningStatistics["three"] = 0
        this.winningStatistics["four"] = 0
        this.winningStatistics["five"] = 0
        this.winningStatistics["six"] = 0
        this.winningStatistics["bonus"] = 0
    }

    fun generateWinningStatistics(userInput: UserInput, ticketPurchase: TicketPurchase) {
        val tickets: MutableList<Lotto> = ticketPurchase.tickets

        for (ticket in tickets) {
            updateWinningStatistics(ticket, userInput)
        }
    }

    private fun updateWinningStatistics(ticket: Lotto, userInput: UserInput) {
        val matches = ticket.getNumbers().count { it in userInput.winningNumbers }

        when (matches) {
            3 -> this.winningStatistics["three"] = this.winningStatistics.getOrDefault("three", 0) + 1
            4 -> this.winningStatistics["four"] = this.winningStatistics.getOrDefault("four", 0) + 1
            5 -> handleFiveMatches(userInput, ticket)
            6 -> this.winningStatistics["six"] = this.winningStatistics.getOrDefault("six", 0) + 1
        }
    }

    private fun handleFiveMatches(userInput: UserInput, ticket: Lotto) {
        if (userInput.bonusNumber in ticket.getNumbers())
            this.winningStatistics["bonus"] = this.winningStatistics.getOrDefault("bonus", 0) + 1
        else
            this.winningStatistics["five"] = this.winningStatistics.getOrDefault("five", 0) + 1
    }

    fun calculateReturnRate(userInput: UserInput) {
        var totalPrize = 0

        for ((key, count) in this.winningStatistics) {
            totalPrize += when (key) {
                "three" -> count * Prizes.FIFTH.prizeMoney
                "four" -> count * Prizes.FOURTH.prizeMoney
                "five" -> count * Prizes.THIRD.prizeMoney
                "bonus" -> count * Prizes.SECOND.prizeMoney
                "six" -> count * Prizes.FIRST.prizeMoney
                else -> 0
            }
        }
        this.returnRate = (totalPrize.toDouble() / userInput.purchaseAmount) * 100
    }

    fun setWinningStatisticsForTest(winningStatistics: MutableMap<String, Int>) {
        this.winningStatistics = winningStatistics
    }
}