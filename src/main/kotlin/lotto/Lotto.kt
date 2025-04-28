package lotto

import lotto.common.ErrorMessages
import lotto.views.InputView
import lotto.views.OutputView

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessages.LOTTO_SIZE_MUST_BE_SIX }
        require(numbers.toSet().size == 6) { ErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE }
        require(numbers.all { it in 1..45 }) { ErrorMessages.LOTTO_NUMBERS_MUST_BE_IN_RANGE }
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