package lotto

import camp.nextstep.edu.missionutils.Randoms

// Main Application class
class LottoApplication {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        try {
            val purchaseAmount = inputView.readPurchaseAmount()
            val tickets = generateTickets(purchaseAmount)
            val winningNumbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()

            val statistics = calculateLottoStatistics(tickets, winningNumbers, bonusNumber)
            val returnRate = calculateReturnRate(statistics, purchaseAmount)

            outputView.printResult(statistics, returnRate)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            run()  // Restart the process in case of an error
        }
    }

    private fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }

    private fun calculateLottoStatistics(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
        val statistics = mutableMapOf<Prize, Int>().apply {
            Prize.values().forEach { put(it, 0) }
        }

        tickets.forEach { ticket ->
            val (matchedCount, isBonusMatch) = ticket.matchCount(winningNumbers, bonusNumber)
            Prize.values().forEach { prize ->
                if (matchedCount == prize.matchCount && (!prize.isBonusRequired || isBonusMatch)) {
                    statistics[prize] = statistics[prize]!! + 1
                }
            }
        }

        return statistics
    }

    private fun calculateReturnRate(statistics: Map<Prize, Int>, purchaseAmount: Int): Double {
        val totalPrizeMoney = statistics.entries.sumOf { (prize, count) -> prize.amount * count }
        val totalTickets = purchaseAmount / 1000
        return if (totalTickets > 0) (totalPrizeMoney / (totalTickets * 1000.0)) * 100 else 0.0
    }
}
