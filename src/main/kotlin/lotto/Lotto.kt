package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
