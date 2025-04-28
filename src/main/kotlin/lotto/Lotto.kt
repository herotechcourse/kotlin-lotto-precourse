package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto numbers must be unique" }


        numbers.forEach { num -> require(num in 1..45) {
            "[ERROR] Lotto numbers must be between 1-45" }
        }
    }

    // TODO: Implement additional functions
    fun numbers (): List<Int> = numbers.sorted()
}
