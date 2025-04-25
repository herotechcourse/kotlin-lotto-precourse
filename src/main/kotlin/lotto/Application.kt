package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.io.InputHandler
import lotto.io.OutputHandler

fun main() {
    val tickets = mutableListOf<Lotto>()
    val sumOfMoney = InputHandler.getSumOfMoney()
    val numberOfTickets = getNumberOfTickets(sumOfMoney)
    validateSumOfMoney(sumOfMoney)
    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
    }
    OutputHandler.showTickets(tickets)
    val winNumbers = InputHandler.getWinningNumbers()
    validateNumbers(winNumbers.map {
        it.toIntOrNull() ?: throw IllegalArgumentException("Winning number should be an integer.")
    })

    val bonusNumber = InputHandler.getBonusNumber()
    validateBonusNumber(bonusNumber)
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

fun validateSumOfMoney(sum: Int) {
    if (sum < 1000) {
        throw IllegalArgumentException("The amount must be divisible by 1,000")
    }

}

fun validateNumbers(numbers: List<Int>) {
    if (numbers.size != 6) {
        throw IllegalArgumentException("You need to write 6 comma-separated numbers")
    }
    if (numbers.size != numbers.toSet().size) {
        throw IllegalArgumentException("You need to write 6 unique numbers")
    }
    for (number in numbers) {
        if (number !in 1..45) {
            throw IllegalArgumentException("Lotto numbers must be between 1 and 45.")
        }
    }
}

fun validateBonusNumber(number: Number) {
    if (number !in 1..45) {
        throw IllegalArgumentException("Bonus number must be between 1 and 45.")
    }
}
