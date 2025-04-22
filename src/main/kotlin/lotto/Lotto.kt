package lotto

import lotto.views.InputView
import lotto.views.OutputView

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    companion object {
        fun run() {
            val amount = InputView.readPurchaseAmount()
            val tickets = LottoMachine.generateTickets(amount)
            OutputView.printTickets(tickets)

            val winningNumbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber(winningNumbers)

            val ranks = tickets.map { ticket ->
                val matchCount = ticket.matchCount(winningNumbers)
                val bonusMatched = ticket.contains(bonusNumber)
                Rank.of(matchCount, bonusMatched)
            }

            val result = LottoResult(ranks)
            OutputView.printStatistics(result, amount)
        }
    }
}