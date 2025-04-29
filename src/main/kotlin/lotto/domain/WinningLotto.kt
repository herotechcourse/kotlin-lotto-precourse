package lotto.domain

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
  init {
    require(winningNumbers.size == 6 && winningNumbers.distinct().size == 6) {
      "[ERROR] Winning numbers must be 6 unique numbers."
    }
    require(bonusNumber in 1..45) { "[ERROR] Bonus number must be in range 1 to 45." }
    require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not overlap winning numbers." }
  }

  fun evaluate(ticket: Lotto): Rank {
    val matchCount = ticket.match(winningNumbers)
    val hasBonus = ticket.contains(bonusNumber)
    return Rank.of(matchCount, hasBonus)
  }
}