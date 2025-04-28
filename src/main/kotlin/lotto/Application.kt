package lotto

fun main() {
    val lotteryMachine = LotteryMachine()
    lotteryMachine.run()
}

class LotteryMachine {
    private val ticketPrice = 1000

    fun run() {
        try {
            val amount = InputView.readPurchaseAmount()
            val tickets = generateTickets(amount)
            OutputView.printPurchasedTickets(tickets)

            val winningLotto = Lotto(InputView.readWinningNumbers())
            val bonusNumber = InputView.readBonusNumber()

            val statistics = analyzeResults(tickets, winningLotto, bonusNumber)
            val totalWinnings = calculateTotalWinnings(statistics)

            OutputView.printWinningStatistics(statistics, amount, totalWinnings)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            run()
        } catch (e: IllegalStateException) {
            println(e.message)
            run()
        }
    }

    private fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / ticketPrice
        val lottoTickets = mutableListOf<Lotto>()

        repeat(ticketCount) {
            val numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoTickets.add(Lotto(numbers))
        }

        return lottoTickets
    }

    fun analyzeResults(
        tickets: List<Lotto>,
        winningLotto: Lotto,
        bonusNumber: Int
    ): Map<Prize, Int> {
        val statistics = mutableMapOf<Prize, Int>()

        for (ticket in tickets) {
            val matchCount = ticket.countMatches(winningLotto)
            val hasBonusMatch = ticket.contains(bonusNumber)
            val rank = Prize.getRank(matchCount, hasBonusMatch)

            if (rank != Prize.NONE) {
                statistics[rank] = statistics.getOrDefault(rank, 0) + 1
            }
        }

        return statistics
    }

    fun calculateTotalWinnings(statistics: Map<Prize, Int>): Long {
        return statistics.entries.sumOf { (rank, count) ->
            rank.prizeAmount * count
        }
    }
}

