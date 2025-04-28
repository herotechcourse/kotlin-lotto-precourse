package lotto

import lotto.Constants.MAX_NUMBER
import lotto.Constants.MIN_NUMBER

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int)
{
    init {
        require(winningNumbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] Bonus number must be between 1 and 45." }
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == winningNumbers.size) { "[ERROR] Winning numbers cannot contain duplicates." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number cannot be one of the winning numbers." }
    }

    fun match(ticket: Lotto): ResultRank {
        val matchCount = ticket.matchNumbers(winningNumbers)
        val containsBonus = ticket.contains(bonusNumber)
        return getResultRank(matchCount, containsBonus)

    }

    private fun getResultRank(matchCount: Int, containsBonus: Boolean): ResultRank {
        require(matchCount in 0..6) { "[ERROR] Match count must be between 0 and 6." }
        return when {
            matchCount == 6 -> ResultRank.SIX
            matchCount == 5 && containsBonus -> ResultRank.FIVE_BONUS
            matchCount == 5 -> ResultRank.FIVE
            matchCount == 4 -> ResultRank.FOUR
            matchCount == 3 -> ResultRank.THREE
            else -> ResultRank.NO_WIN
        }
    }
}