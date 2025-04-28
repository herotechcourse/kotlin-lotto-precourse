package lotto

object LottoManager {

    fun run() {
        val purchaseAmount = retry {
            val input = InputView.readPurchaseAmount()
            val amount = InputParser.parseToInt(input)
            InputValidator.validatePurchaseAmount(amount)
        }

        val ticketCount = purchaseAmount / 1000
        val tickets = LottoMachine.issueTickets(ticketCount)

        OutputView.printTickets(tickets)

        val winningNumbers = retry {
            val input = InputView.readWinningNumbers()
            val numbers = InputParser.parseToNumbers(input)
            Lotto(numbers)
        }

        val bonusNumber = retry {
            val input = InputView.readBonusNumber()
            val bonus = InputParser.parseToInt(input)
            InputValidator.validateBonusNumber(bonus, winningNumbers.getNumbers())
            bonus
        }

        val lottoResult = LottoResult(winningNumbers, bonusNumber)
        val ranks = lottoResult.calculateRanks(tickets)
        val statistics = lottoResult.getStatistics(ranks)

        OutputView.printStatistics(statistics)

        val totalWinningAmount = lottoResult.calculateWinningAmount(statistics)
        val returnRate = lottoResult.calculateReturnRate(totalWinningAmount, purchaseAmount)

        OutputView.printReturnRate(returnRate)
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
