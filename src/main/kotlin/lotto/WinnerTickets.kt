package lotto

class WinnerTickets(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning ticket must contain exactly 6 numbers." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
    }

    fun matchCount(ticket: Lotto): Int {
        return ticket.getNumbers().count { winningNumbers.contains(it) }
    }

    fun hasBonus(ticket: Lotto): Boolean {
        return ticket.getNumbers().contains(bonusNumber)
    }

    fun getRank(ticket: Lotto): Rank {
        return Rank.from(matchCount(ticket), hasBonus(ticket))
    }
}