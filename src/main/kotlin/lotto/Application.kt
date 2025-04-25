package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val tickets = mutableListOf<Lotto>()
    println("Please enter the purchase amount.")
    val sumOfMoney = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] The purchase amount should be an integer.")
    val numberOfTickets = getNumberOfTickets(sumOfMoney)
    validateSumOfMoney(sumOfMoney)
    println("You have purchased $numberOfTickets tickets.")

    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
        ticket.showNumbers()
    }

    println("Please enter last week's winning numbers.")
    val winNumbers = Console.readLine().split(",").map { it.trim() }
    validateNumbers(winNumbers.map {
        it.toIntOrNull() ?: throw IllegalArgumentException("Winning number should be an integer.")
    })

    println("Please enter the bonus number.")
    val bonusNumber = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The purchase amount should be an integer.")
    validateBonusNumber(bonusNumber)
    val ticketMatchesMap = mutableMapOf(
        "match3" to 0,
        "match4" to 0,
        "match5" to 0,
        "match5andBonus" to 0,
        "match6" to 0,
    )

    println("Winning Statistics")
    println("---")
    for (ticket in tickets) {
        val matches = ticket.calculateMatches(winNumbers.map { it.toInt() })
        when (matches) {
            3 -> ticketMatchesMap["match3"] = ticketMatchesMap["match3"]!! + 1;
            4 -> ticketMatchesMap["match4"] = ticketMatchesMap["match4"]!! + 1;
            5 -> ticketMatchesMap["match5"] = ticketMatchesMap["match5"]!! + 1;
            6 -> ticketMatchesMap["match6"] = ticketMatchesMap["match6"]!! + 1;
        }
    }
    fun countReturnRate(): Double {
        val returnRate = (ticketMatchesMap["match3"]!! * 5000 + ticketMatchesMap["match4"]!! * 50000 +
                ticketMatchesMap["match5"]!! * 1500000 + ticketMatchesMap["match6"]!! * 2000000000).toDouble() * 100 / sumOfMoney
        return returnRate
    }
    println(
        "3 Matches (5,000 KRW) – ${ticketMatchesMap["match3"]} tickets\n" +
                "4 Matches (50,000 KRW) – ${ticketMatchesMap["match4"]} tickets\n" +
                "5 Matches (1,500,000 KRW) – ${ticketMatchesMap["match5"]} tickets\n" +
                "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets\n" +
                "6 Matches (2,000,000,000 KRW) – ${ticketMatchesMap["match6"]} tickets"
    )
    println("Total return rate is ${countReturnRate()}%. ")
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
