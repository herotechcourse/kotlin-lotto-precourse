package lotto

private const val LOTTO_PRICE = 1000
private const val LOTTO_NUMBER_COUNT = 6
private const val LOTTO_MIN_NUMBER = 1
private const val LOTTO_MAX_NUMBER = 45

class Lotto(private val numbers: List<Int>) {
  init {
    require(numbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers." }
    require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { "[ERROR] Lotto numbers must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER." } 
    require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto numbers must be unique." }
  }

  fun getNumbers(): List<Int> {
    return numbers.sorted()
  }

  fun countMatchingNumbers(winningNumbers: List<Int>): Int {
    return numbers.count { it in winningNumbers }
  }

  fun containsNumber(number: Int): Boolean {
    return numbers.contains(number)
  }
}
