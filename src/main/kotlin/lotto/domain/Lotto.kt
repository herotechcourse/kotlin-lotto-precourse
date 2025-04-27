package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto must not contain duplicates" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto number must be between 1-45" }
    }

    // TODO: Implement additional functions
}
