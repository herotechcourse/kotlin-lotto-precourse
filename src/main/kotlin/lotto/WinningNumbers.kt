package lotto

class WinningNumbers(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    init {
        require(winningNumbers.size == 6) { "[ERROR] Must provide exactly 6 winning numbers." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }

        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number must not be among winning numbers." }
    }

    fun countMatch(ticket: Lotto): Int {
        return ticket.getNumbers().count { it in winningNumbers }
    }

    fun isBonusMatch(ticket: Lotto): Boolean {
        return bonusNumber in ticket.getNumbers()
    }

}
