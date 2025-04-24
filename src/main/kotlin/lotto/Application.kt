package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val tickets = mutableListOf<Lotto>()
    println("Please enter the purchase amount.")
    val sumOfMoney = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The purchase amount should be an integer.")
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

    println("Winning Statistics")
    println("---")
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
