package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun numberList(): List<Int> {
        return numbers
    }

    fun numberSet(): Set<Int> {
        return numbers.toSet()
    }
}
