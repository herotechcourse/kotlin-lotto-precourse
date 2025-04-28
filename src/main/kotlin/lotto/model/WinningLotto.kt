package lotto.model

import lotto.Lotto

private const val LOTTO_PRICE = 1000
private const val LOTTO_NUMBER_COUNT = 6
private const val LOTTO_MIN_NUMBER = 1
private const val LOTTO_MAX_NUMBER = 45

class WinningLotto(private val numbers: List<Int>, private val bonusNumber: Int) {
  init {
    require(winningNumbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Winning numbers must contain exactly $LOTTO_NUMBER_COUNT numbers." }
    require(winningNumbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { "[ERROR] Winning numbers must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER." }
    require(winningNumbers.distinct().size == winningNumbers.size) { "[ERROR] Winning numbers must be unique." }
    require(bonusNumber in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { "[ERROR] Bonus number must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER." }
  }

  fun getNumbers(): List<Int> {
    return numbers
  }

  fun getBonusNumber(): Int {
    return bonusNumber
  }

  fun match(lotto: Lotto): Prize {
    val matchingCount = lotto.getNumbers().count { it in numbers }
    val hasBonus = lotto.containsNumber(bonusNumber)
    return Prize.getPrize(matchingCount, hasBonus)
  }
}