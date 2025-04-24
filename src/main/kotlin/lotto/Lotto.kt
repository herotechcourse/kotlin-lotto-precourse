package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == numbers.size) {
            "[ERROR] Lotto must not contain duplicate numbers."
        }
        require(numbers.all { it in 1..45 }) { "[ERROR] All numbers must be between 1 and 49." }
    }

    // TODO: Implement additional functions
}
