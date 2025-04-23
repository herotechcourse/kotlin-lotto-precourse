package lotto

class LottoGame {
    private val LOTTO_PRICE = 1000
    private val WINNING_PRIZES = mapOf(
        6 to 2_000_000_000,
        5 to 1_500_000,
        4 to 50_000,
        3 to 5_000
    )
    private val SECOND_PRIZE = 30_000_000

    fun createLottoTickets(money: Int): List<Lotto> {
        require(money % LOTTO_PRICE == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        val ticketCount = money / LOTTO_PRICE
        return List(ticketCount) { createRandomLotto() }
    }

    private fun createRandomLotto(): Lotto {
        val numbers = (1..45).shuffled().take(6)
        return Lotto(numbers)
    }

    fun calculateWinningStatistics(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Int, Int> {
        val statistics = mutableMapOf<Int, Int>()
        tickets.forEach { ticket ->
            val matchCount = ticket.countMatchingNumbers(winningNumbers)
            if (matchCount == 5 && ticket.containsBonusNumber(bonusNumber)) {
                statistics[5] = (statistics[5] ?: 0) + 1
            } else if (matchCount >= 3) {
                statistics[matchCount] = (statistics[matchCount] ?: 0) + 1
            }
        }
        return statistics
    }

    fun calculateTotalPrize(statistics: Map<Int, Int>): Int {
        var total = 0
        statistics.forEach { (matchCount, count) ->
            if (matchCount == 5) {
                total += SECOND_PRIZE * count
            } else {
                total += (WINNING_PRIZES[matchCount] ?: 0) * count
            }
        }
        return total
    }

    fun calculateProfitRate(totalPrize: Int, investment: Int): Double {
        return (totalPrize.toDouble() / investment) * 100
    }
} 