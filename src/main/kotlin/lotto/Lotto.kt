package lotto

class Lotto(private val numbers: List<Int>) {
  init {
    require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    require(numbers.distinct().size == 6) {"[ERROR] Lotto numbers must be unique."}
  }
  fun getSortedNumbers(): List<Int> = numbers.sorted()
  
  fun countMatchingNumbers(winningNumbers: List<Int>): Int {
    return numbers.count { it in winningNumbers }
  }

  fun hasBonusNumber(bonusNumber: Int): Boolean {
    return numbers.contains(bonusNumber)
  }
}
