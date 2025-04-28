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

    requireNotNull(purchaseAmount) { "[ERROR] purchase amount must be an integer" }
    require(purchaseAmount > 0) { "[ERROR] amount must be a positive number." }
    require(purchaseAmount % 1000 == 0) { "[ERROR] Each ticket costs 1,000 KRW" }

    return purchaseAmount
}

fun createOneTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun createMultipleTickets(ticketCount: Int): List<Lotto> {
    val lottoTickets = mutableListOf<Lotto>()
    repeat(ticketCount) {
        lottoTickets.add(createOneTicket())
    }
    return lottoTickets
}

fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers. (comma-separated)")
    val winningNumbers = Console.readLine().split(",")
        .map { requireNotNull(it.trim().toIntOrNull()) { "[ERROR] Winning numbers must be integers." } }

    require(winningNumbers.size == 6) { "[ERROR] Exactly 6 numbers must be entered." }
    require(winningNumbers.toSet().size == winningNumbers.size) { "[ERROR] Duplicate numbers are not allowed." }
    require(winningNumbers.all { it >= 1 && it <= 45 }) { "[ERROR] Numbers must be between 1 and 45." }

    return winningNumbers
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val bonusNumber = Console.readLine().toIntOrNull()

    requireNotNull(bonusNumber) { "[ERROR] Bonus number must be an integer." }
    require(bonusNumber >= 1 && bonusNumber <= 45) { "[ERROR] Numbers must be between 1 and 45." }
    require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number must not duplicate winning numbers." }

    return bonusNumber
}

fun calculateMatchResult(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int): MatchResult {
    val matchCount = ticket.getNumbers().count { it in winningNumbers }
    val bonusMatched = ticket.getNumbers().contains(bonusNumber)
    return MatchResult(matchCount, bonusMatched)
}

fun calculatePrizeRanks(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<PrizeRank> {
    return tickets.map { ticket ->
        val matchResult = calculateMatchResult(ticket, winningNumbers, bonusNumber)
        PrizeRank.from(matchResult.matchCount, matchResult.bonusMatched)
    }
}

fun main() {
    val purchaseAmount = promptUntilValid {
        readPurchaseAmount()
    }
    println()
    val ticketCount = purchaseAmount / 1000
    println("You have purchased $ticketCount tickets.")
    val tickets = createMultipleTickets(ticketCount)
    for (ticket in tickets) {
        println(ticket)
    }
    println()

    val winningNumbers = promptUntilValid {
        readWinningNumbers()
    }
    println()

    val bonusNumber = promptUntilValid {
        readBonusNumber(winningNumbers)
    }
    println()

    calculatePrizeRanks(tickets, winningNumbers, bonusNumber)
    println("Winning Statistics")
    println("---")

}
