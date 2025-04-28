package lotto

import camp.nextstep.edu.missionutils.Randoms

class LotteryMachine {

    fun purchaseTickets(input: String): List<Lotto> {
        // Check if the amount is a valid number
        try {
            // Validate if the amount is divisible by 1000
            if (input.toInt() % 1000 != 0) {
                throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT.message)
            }
            val ticketCount = input.toInt() / 1000
            val tickets = mutableListOf<Lotto>()

            repeat(ticketCount) {
                val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                tickets.add(Lotto(numbers))
            }

            return tickets
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_FORMAT.message)
        }
    }

    fun calculateWinnings(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
        val prizeCounts = mutableMapOf(
            "6 Matches" to 0,
            "5 Matches + Bonus Ball" to 0,
            "5 Matches" to 0,
            "4 Matches" to 0,
            "3 Matches" to 0
        )

        tickets.forEach { ticket ->
            val (matchCount, bonusMatch) = ticket.matchCount(winningNumbers, bonusNumber)

            when (matchCount) {
                6 -> prizeCounts["6 Matches"] = prizeCounts.getOrDefault("6 Matches", 0) + 1
                5 -> if (bonusMatch) {
                    prizeCounts["5 Matches + Bonus Ball"] = prizeCounts.getOrDefault("5 Matches + Bonus Ball", 0) + 1
                } else {
                    prizeCounts["5 Matches"] = prizeCounts.getOrDefault("5 Matches", 0) + 1
                }
                4 -> prizeCounts["4 Matches"] = prizeCounts.getOrDefault("4 Matches", 0) + 1
                3 -> prizeCounts["3 Matches"] = prizeCounts.getOrDefault("3 Matches", 0) + 1
            }
        }

        return prizeCounts
    }

    fun calculateReturnRate(prizeCounts: Map<String, Int>, ticketCount: Int): Double {
        val prizeAmounts = mapOf(
            "6 Matches" to 2_000_000_000,
            "5 Matches + Bonus Ball" to 30_000_000,
            "5 Matches" to 1_500_000,
            "4 Matches" to 50_000,
            "3 Matches" to 5_000
        )

        var totalWinnings = 0
        prizeCounts.forEach { (prize, count) ->
            totalWinnings += prizeAmounts.getValue(prize) * count
        }

        return (totalWinnings.toDouble() / (ticketCount * 1_000)) * 100
    }

}
