package lotto.domain

class WinningNumbers(private val numbers: List<Int>, private val bonus: Int) {
    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must be exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonus !in numbers) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    fun match(ticket: Lotto): Prize {
        val ticketNumbers = ticket.getNumbers()
        val matchCount = ticketNumbers.count { it in numbers }
        val bonusMatch = bonus in ticketNumbers
        return Prize.of(matchCount, bonusMatch)
    }
}
