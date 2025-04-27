package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.io.InputHandler
import lotto.io.OutputHandler
import lotto.validators.InputValidator


fun main() {
    val tickets = mutableListOf<Lotto>()
    val sumOfMoney = InputHandler.getSumOfMoney()
    val numberOfTickets = getNumberOfTickets(sumOfMoney)
//  validateSumOfMoney(sumOfMoney)
    InputValidator.validateSumOfMoney(sumOfMoney)
    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
    }
    OutputHandler.showTickets(tickets)
    val winNumbers = InputHandler.getWinningNumbers()
    InputValidator.validateNumbers(winNumbers.map {
        it.toIntOrNull() ?: throw IllegalArgumentException("Winning number should be an integer.")
    })

    val bonusNumber = InputHandler.getBonusNumber()
    InputValidator.validateNumberInRange(bonusNumber)

    val results = LottoResults()

    for (ticket in tickets) {
        val matches = ticket.calculateMatches(winNumbers.map { it.toInt() })
        when (matches) {
            3 -> results.increaseMatchResult(LottoRanks.MATCH_3)
            4 -> results.increaseMatchResult(LottoRanks.MATCH_4)
            5 -> results.increaseMatchResult(LottoRanks.MATCH_5)
            6 -> results.increaseMatchResult(LottoRanks.MATCH_6)
        }
    }

    val totalRate = results.countReturnRate(sumOfMoney)

    OutputHandler.showStatistics(results)
    OutputHandler.showTotalRate(totalRate)
}

fun getNumberOfTickets(sum: Int): Int {
    return sum / 1000
}
