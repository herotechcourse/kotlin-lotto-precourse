package lotto

class Lotto(private val numbers: List<Int>) {
  init {
    require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
    require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER}) { "[ERROR] Lotto numbers must be between 1 and 45." }
    require(numbers.distinct().size == LOTTO_NUMBER_SIZE) {"[ERROR] Lotto numbers must be unique."}
  }
  fun getSortedNumbers(): List<Int> = numbers.sorted()

  fun countMatchingNumbers(winningNumbers: List<Int>): Int {
    return numbers.count { it in winningNumbers }
  }

  fun hasBonusNumber(bonusNumber: Int): Boolean {
    return numbers.contains(bonusNumber)
  }
}
