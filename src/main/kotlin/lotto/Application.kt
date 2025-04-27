package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().run()
}

class Application {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoService = LottoService()

    fun run() {
        val amount = inputView.readPurchaseAmount()
        val tickets = lottoService.generateTickets(amount)
        outputView.printTickets(tickets)
        val winningNumbers = inputView.readWinningNumbers()
        val bonus = inputView.readBonusNumber(winningNumbers)

        val prizes = lottoService.calculatePrizes(tickets, winningNumbers, bonus)
        val totalWinnings = prizes.map { (prize, count) -> prize.amount * count }.sum()
        val profitRate = lottoService.calculateProfitRate(totalWinnings, amount)

        outputView.printWinningStatistics(prizes)
        outputView.printProfitRate(profitRate)
    }
}

class InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                // Re-prompt for purchase amount
            }
        }
    }


    fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers (comma-separated).")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return parseNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                // Re-prompt for winning numbers
            }
        }
    }

    fun parseNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be integers.") }
        if (numbers.size != 6 || numbers.any { it !in 1..45 } || numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateBonus(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                // Re-prompt for bonus number
            }
        }
    }

    fun validateBonus(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")
        if (bonus !in 1..45 || bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45 and not in winning numbers.")
        }
        return bonus
    }

}

class LottoService {

    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) { generateTicket() }
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun calculatePrizes(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): Map<Prize, Int> {
        val prizeCounts = mutableMapOf<Prize, Int>()
        tickets.forEach { ticket ->
            val prize = determinePrize(ticket, winningNumbers, bonus)
            if (prize != null) prizeCounts[prize] = (prizeCounts[prize] ?: 0) + 1
        }
        return prizeCounts
    }

    fun calculateProfitRate(totalWinnings: Long, amount: Int): Double {
        return (totalWinnings.toDouble() / amount) * 100
    }

    fun determinePrize(ticket: Lotto, winningNumbers: List<Int>, bonus: Int): Prize? {
        val matches = ticket.getNumbers().intersect(winningNumbers).size
        val hasBonus = bonus in ticket.getNumbers()
        return Prize.values().firstOrNull { it.matchCount == matches && (!it.bonusRequired || hasBonus) }
    }
}

class OutputView {

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printWinningStatistics(prizes: Map<Prize, Int>) {
        println("Winning Statistics")
        println("---")
        // List prizes from 3 matches to 6 matches (reversed order of Prize.values())
        Prize.values().reversed().forEach { prize ->
            val count = prizes[prize] ?: 0
            val bonusText = if (prize.bonusRequired) " + Bonus Ball" else ""
            // Format prize amount with commas
            val formattedAmount = String.format("%,d", prize.amount)
            // Use en dash (–) instead of hyphen (-)
            println("${prize.matchCount} Matches$bonusText ($formattedAmount KRW) – $count tickets")
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%.".format(profitRate))
    }
}

enum class Prize(val matchCount: Int, val bonusRequired: Boolean, val amount: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000)
}
