package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers(): Set<Int> {
        return numbers.toSet()
    }
}
