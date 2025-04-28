package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) {
            "[ERROR] Lotto must contain exactly 6 unique numbers."
        }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
    }

    fun numbers(): List<Int> = numbers.toList()
}
