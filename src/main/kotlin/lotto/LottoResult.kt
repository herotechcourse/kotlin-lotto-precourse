package lotto

class LottoResult {
    var winningStatics: MutableMap<String, Int> = mutableMapOf()
        private set
    var returnRate: Double = 0.0
        private set

    init {
        this.winningStatics["three"] = 0
        this.winningStatics["four"] = 0
        this.winningStatics["five"] = 0
        this.winningStatics["six"] = 0
        this.winningStatics["bonus"] = 0
    }

    fun generateWinningStatistics(userInput: UserInput, ticketPurchase: TicketPurchase) {
        val tickets = ticketPurchase.tickets

        for (ticket in tickets) {
            val matches = ticket.getNumbers().count {it in userInput.winningNumbers }
            when (matches) {
                3 -> this.winningStatics["three"] = this.winningStatics.getOrDefault("three", 0) + 1
                4 -> this.winningStatics["four"] = this.winningStatics.getOrDefault("four", 0) + 1
                5 -> {
                    if (userInput.bonusNumber in ticket.getNumbers())
                        this.winningStatics["bonus"] = this.winningStatics.getOrDefault("bonus", 0) + 1
                    else
                        this.winningStatics["five"] = this.winningStatics.getOrDefault("five", 0) + 1
                }
                6 -> this.winningStatics["six"] = this.winningStatics.getOrDefault("six", 0) + 1
            }
        }
    }

    fun calculateReturnRate(userInput: UserInput) {
        var totalPrize = 0

        for ((key, count) in this.winningStatics) {
            totalPrize += when (key) {
                "three" -> count * FIFTH_PRIZE
                "four" -> count * FOURTH_PRIZE
                "five" -> count * THIRD_PRIZE
                "bonus" -> count * SECOND_PRIZE
                "six" -> count * FIRST_PRIZE
                else -> 0
            }
        }

        this.returnRate = (totalPrize.toDouble() / userInput.purchaseAmount) * 100
    }

}