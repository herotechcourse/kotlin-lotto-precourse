package lotto

import WinningNumberValidator
import lotto.services.GenerateTickets
import lotto.services.LottoStatistics
import lotto.utils.StringToList
import lotto.utils.StringToNumber
import lotto.validator.BudgetValidator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    while (true) {
        try {
            val application = Application()
            application.run()
            break
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}

class Application {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottery = GenerateTickets()

    fun run() {
        val budget = readBudget()
        val ticketCount = calculateTicketCount(budget)
        val tickets = issueTickets(ticketCount)

        outputView.purchasedTicket(ticketCount)
        outputView.ticketNumber(tickets)

        val (winningNumber, bonus) = readWinningNumbers()

        val lottos = createLottoList(tickets)
        val winningLotto = Lotto(winningNumber)
        val statistics = LottoStatistics(lottos, winningLotto, bonus)
        statistics.calculate()
        val rate = statistics.calculateProfitRate(budget)

        outputView.printStatistics(statistics)
        outputView.printProfitRate(rate)
    }

    private fun readBudget(): Int {
        val budgetInput = inputView.getBudget()
        val budgetOrNull = StringToNumber(budgetInput)
        return BudgetValidator().run(budgetOrNull)
    }

    private fun calculateTicketCount(budget: Int): Int {
        return lottery.getLotteryCount(budget)
    }

    private fun issueTickets(ticketCount: Int): List<List<Int>> {
        return lottery.run(ticketCount)
    }

    private fun readWinningNumbers(): Pair<List<Int>, Int> {
        val winningValidator = WinningNumberValidator()

        val winningNumbersInput = inputView.getWinnings()
        val winningNumberList = StringToList(winningNumbersInput)
        val winningNumbers = winningValidator.run(winningNumberList)

        val bonusInput = inputView.getBonusNumber()
        val bonusNumber = StringToNumber(bonusInput)
        val bonus = winningValidator.getBonus(bonusNumber)

        return Pair(winningNumbers, bonus)
    }

    private fun createLottoList(tickets: List<List<Int>>): List<Lotto> {
        return tickets.map { ticket -> Lotto(ticket) }
    }
}