package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Duplicate Numbers are entered" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers outside the range of 1 to 45 are entered" }
    }

    // TODO: Implement additional functions
}
