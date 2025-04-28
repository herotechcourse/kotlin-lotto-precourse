package lotto

class Lotto(private val numbers: List<Int>) {
  init {
    require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    require(numbers.toSet().size == numbers.size){"[ERROR] Lotto must not contain duplicates."}
  }

  fun getNumbers(): List<Int> = numbers.sorted()

  fun countMatching(winningNumbers: List<Int>): Int {
    return numbers.count { it in winningNumbers }
  }

  fun contains(bonus: Int): Boolean {
    return numbers.contains(bonus)
  }
}
