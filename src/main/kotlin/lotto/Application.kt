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
    val ticketMatchesMap = mutableMapOf(
        "match3" to 0,
        "match4" to 0,
        "match5" to 0,
        "match5andBonus" to 0,
        "match6" to 0,
    )

    for (ticket in tickets) {
        val matches = ticket.calculateMatches(winNumbers.map { it.toInt() })
        when (matches) {
            3 -> ticketMatchesMap["match3"] = ticketMatchesMap["match3"]!! + 1
            4 -> ticketMatchesMap["match4"] = ticketMatchesMap["match4"]!! + 1
            5 -> ticketMatchesMap["match5"] = ticketMatchesMap["match5"]!! + 1
            6 -> ticketMatchesMap["match6"] = ticketMatchesMap["match6"]!! + 1
        }
    }

    fun countReturnRate(): Double {
        val returnRate =
            (ticketMatchesMap["match3"]!! * 5000 + ticketMatchesMap["match4"]!! * 50000 + ticketMatchesMap["match5"]!! * 1500000 + ticketMatchesMap["match6"]!! * 2000000000).toDouble() * 100 / sumOfMoney
        return returnRate
    }

    val totalRate = countReturnRate()

    OutputHandler.showStatistics(ticketMatchesMap)
    OutputHandler.showTotalRate(totalRate)
}

fun getNumberOfTickets(sum: Int): Int {
    return sum / 1000
}
