package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Each Lotto number must be unique." }
    }
    fun numbersGetter(): List<Int> {
        return numbers
    }

}
