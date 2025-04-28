package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LOTTO_NUMBER_SIZE_ERROR }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_ERROR: String = "Lotto must contain exactly 6 numbers."
    }
}
