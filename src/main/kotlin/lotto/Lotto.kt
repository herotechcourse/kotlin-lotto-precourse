package lotto

class Lotto(private val numbers: List<Int>) {
  init {
    require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
  }

  fun countMatch(other: Set<Int>): Int = numbers.count { it in other }
  fun containsBonus(bonus: Int): Boolean = bonus in numbers
  override fun toString() = numbers.sorted().toString()
}
