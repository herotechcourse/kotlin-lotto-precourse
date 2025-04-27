package lotto

class Lotto(val numbers: List<Int>) {
  init {
    require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
  }

  fun matchRank(winningNumbers: List<Int>, bonus: Int): PrizeRank {
    val matchCount = numbers.count { it in winningNumbers }
    val matchBonus = numbers.contains(bonus)
    return PrizeRank.valueOf(matchCount, matchBonus)
  }
}
