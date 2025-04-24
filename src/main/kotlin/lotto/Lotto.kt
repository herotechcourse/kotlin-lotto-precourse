package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto must contain unique numbers."}
        numbers.forEach {
            number -> require(number in 1..45) { "[ERROR] Lotto must contain numbers in range 1..45."}
        }
    }

    // TODO: Implement additional functions
}
