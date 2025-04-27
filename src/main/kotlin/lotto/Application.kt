package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        println("Please entre the Purchase amount:")
        println("Purchase Amount Must be divisible by 1000")
        val amount = Console.readLine().toInt()
        val ticketCount = ticketCost(amount)
        println("You have purchased $ticketCount tickets.") // <<< fixed text

        val lottoTicket = generateLottoTickets(ticketCount)
        lottoTicket.forEach { println(it) }
        println("Please entre the winning numbers (comma-separated):")
        val inputNumbers: String = Console.readLine()
        val winningNumbers = validWinningNumbers(inputNumbers)
        println("Please entre the bonus number:")
        val bonus = Console.readLine()
        val bonusNumber = validBonusNumber(bonus, winningNumbers)
        println("The bonus number is  $bonusNumber")
        lottoTicket.forEach { ticket ->
            val result = compareTicketToWinningNumbers(ticket, winningNumbers, bonusNumber)
            println("Ticket: ${ticket.getNumbers()} - Result: $result")
        }
        println("Winning Statistics")

        val prizeStats = calculatePrizeStatistics(lottoTicket, winningNumbers, bonusNumber)
        prizeStats.forEach { (prize, count) ->
            println("$prize – $count tickets")
        }

        val totalReturnRate = calculateProfitRate(amount, prizeStats)
        println("Total return rate is $totalReturnRate%.")
    } catch (e: IllegalArgumentException) {
        println("[ERROR]")
    }
}


fun ticketCost(input:Int): Int {
    if (input % 1000 != 0) {
        throw IllegalArgumentException("Amount must be divisible by 1,000")
    }
    return input / 1000
}

fun generateLottoTickets (ticketCount: Int) : List<Lotto> {
    val tickets = mutableListOf<Lotto>()
    repeat(ticketCount) {
        val ticketsNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        tickets.add(Lotto(ticketsNumbers))
    }
    return tickets
}

fun validWinningNumbers(input:String):List<Int> {
    val numbers =
        input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("Invalid winning numbers") }

    if (numbers.size != 6) {
        throw IllegalArgumentException("entered Numbers must be 6 numbers")
    }
    if (numbers.toSet().size != 6) {
        throw IllegalArgumentException("Numbers must be Unique")
    }
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("Numbers must be between 1 and 45")
    }
    return numbers
}

fun validBonusNumber(input:String, winningNumbers:List<Int>):Int {
    val bonus = input.trim().toIntOrNull() ?: throw IllegalArgumentException("Invalid bonus number")

    if (bonus !in 1..45) {
        throw IllegalArgumentException("Bonus number must be between 1 and 45")
    }
    if (bonus in winningNumbers) {
        throw IllegalArgumentException("Bonus number must be not in the winning numbers")
    }
    return bonus
}
fun compareTicketToWinningNumbers(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int): String {
    val matchedNumbers = ticket.getNumbers().intersect(winningNumbers.toSet()).size
    val matchedBonusNumber = ticket.getNumbers().contains(bonusNumber)

    return when {
        matchedNumbers == 6 -> "6 Matches (2,000,000,000 KRW)"
        matchedNumbers == 5 && matchedBonusNumber -> "5 Matches + Bonus Ball (30,000,000 KRW)"
        matchedNumbers == 5 -> "5 Matches (1,500,000 KRW)"
        matchedNumbers == 4 -> "4 Matches (50,000 KRW)"
        matchedNumbers == 3 -> "3 Matches (5,000 KRW)"
        else -> "no prize"
    }
}
fun calculatePrizeStatistics(lottoTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
    val prizeStatistics = mutableMapOf(
        "3 Matches (5,000 KRW)" to 0,
        "4 Matches (50,000 KRW)" to 0,
        "5 Matches (1,500,000 KRW)" to 0,
        "5 Matches + Bonus Ball (30,000,000 KRW)" to 0,
        "6 Matches (2,000,000,000 KRW)" to 0
    )

    lottoTickets.forEach { ticket ->
        val result = compareTicketToWinningNumbers(ticket, winningNumbers, bonusNumber)
        prizeStatistics[result] = prizeStatistics.getOrDefault(result, 0) + 1
    }

    return prizeStatistics
}

fun calculateProfitRate(amount: Int, prizeStats: Map<String, Int>): Double {
    val prizeAmounts = mapOf(
        "6 Matches (2,000,000,000 KRW)" to 2_000_000_000,
        "5 Matches + Bonus (30,000,000 KRW)" to 30_000_000,
        "5 Matches (1,500,000 KRW)" to 1_500_000,
        "4 Matches (50,000 KRW)" to 50_000,
        "3 Matches (5,000 KRW)" to 5_000
    )

    val totalWinnings = prizeStats.entries.sumBy { (prize, count) ->
        prizeAmounts.getOrDefault(prize, 0) * count
    }

    return (totalWinnings.toDouble() / amount) * 100
}