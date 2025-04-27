package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun <T> promptUntilValid(prompt: () -> T): T {
    while (true) {
        try {
            return prompt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val userInput = Console.readLine()
    val purchaseAmount = userInput.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] purchase amount must be an integer")
    return purchaseAmount
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] amount must be a positive number.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Each ticket costs 1,000 KRW")
    }
}

fun createOneTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun createMultipleTickets(ticketCount: Int): List<Lotto> {
    val lottoTickets = mutableListOf<Lotto>()
    repeat(ticketCount){
        lottoTickets.add(createOneTicket())
    }
    return lottoTickets
}

fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers. (comma-separated)")
    val winningNumbers = Console.readLine()
        .split(",")
        .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be integers.") }
    return winningNumbers
}

fun validateWinningNumbers(winningNumbers: List<Int>) {
    if (winningNumbers.size != 6) {
        throw IllegalArgumentException("[ERROR] Exactly 6 numbers must be entered.")
    }
    if (winningNumbers.toSet().size != winningNumbers.size){
        throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
    }
    if (winningNumbers.any { it < 1 || it > 45 }) {
        throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }
}

fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    val bonusNumber = Console.readLine()
        .toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")
    return bonusNumber
}

fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
    if (bonusNumber < 1 || bonusNumber > 45 ) {
        throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }
    if (winningNumbers.contains(bonusNumber)) {
        throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
    }
}

fun main() {
    val purchaseAmount = promptUntilValid {
        val amount = readPurchaseAmount()
        validatePurchaseAmount(amount)
        amount
    }
    println()
    val ticketCount = purchaseAmount / 1000
    println("You have purchased $ticketCount tickets.")
    val tickets = createMultipleTickets(ticketCount)
    for (ticket in tickets){
        println(ticket)
    }
    println()
    val winningNumbers = promptUntilValid {
        val numbers = readWinningNumbers()
        validateWinningNumbers(numbers)
        numbers
    }
    println()
    val bonusNumber = promptUntilValid {
        val bonus = readBonusNumber()
        validateBonusNumber(bonus, winningNumbers)
        bonus
    }
}
