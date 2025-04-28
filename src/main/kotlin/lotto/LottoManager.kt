package lotto

object LottoManager {
    private const val TICKET_PRICE = 1000

    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val tickets = issueTickets(purchaseAmount)
        OutputView.printTickets(tickets)

        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber(winningNumbers)

        val statistics = calculateStatistics(tickets, winningNumbers, bonusNumber)
        OutputView.printStatistics(statistics)

        val returnRate = calculateReturnRate(statistics, purchaseAmount)
        OutputView.printReturnRate(returnRate)
    }

    private fun readPurchaseAmount(): Int = retry {
        val input = InputView.readPurchaseAmount()
        val amount = InputParser.parseToInt(input)
        InputValidator.validatePurchaseAmount(amount)
    }

    private fun issueTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_PRICE
        return LottoMachine.issueTickets(ticketCount)
    }

    private fun readWinningNumbers(): Lotto = retry {
        val input = InputView.readWinningNumbers()
        val numbers = InputParser.parseToNumbers(input)
        Lotto(numbers)
    }

    private fun readBonusNumber(winningNumbers: Lotto): Int = retry {
        val input = InputView.readBonusNumber()
        val bonus = InputParser.parseToInt(input)
        InputValidator.validateBonusNumber(bonus, winningNumbers.getNumbers())
        bonus
    }

    private fun calculateStatistics(
        tickets: List<Lotto>,
        winningNumbers: Lotto,
        bonusNumber: Int
    ): Map<LottoRank, Int> {
        val lottoResult = LottoResult(winningNumbers, bonusNumber)
        val ranks = lottoResult.calculateRanks(tickets)
        return lottoResult.getStatistics(ranks)
    }

    private fun calculateReturnRate(
        statistics: Map<LottoRank, Int>,
        purchaseAmount: Int
    ): Double {
        val totalWinningAmount = statistics.entries.sumOf { it.key.prize.toLong() * it.value }
        return (totalWinningAmount.toDouble() / purchaseAmount) * 100
    }

    private fun <T> retry(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
