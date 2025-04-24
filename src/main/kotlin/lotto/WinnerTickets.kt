package lotto

class WinnerTickets(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_INVALID_WINNING_NUMBERS }
        require(winningNumbers.toSet().size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_WINNING_NUMBERS_UNIQUE }
        require(winningNumbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) { Constants.ERROR_WINNING_NUMBERS }
        require(bonusNumber in Constants.MIN_NUMBER..Constants.MAX_NUMBER) { Constants.ERROR_INVALID_BONUS_NUMBER }
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