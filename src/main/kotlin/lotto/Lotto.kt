package lotto

data class Lotto(private val _numbers: List<Int>) {
    init {
        require(_numbers.size == LOTTO_NUMBER_SIZE) {
            "[ERROR] Lotto must contain exactly ${LOTTO_NUMBER_SIZE} numbers."
        }
        require(_numbers.toSet().size == _numbers.size) {
            "[ERROR] Lotto must contain unique numbers."
        }
        require(_numbers.all { it in 1..45 }) {
            "[ERROR] All numbers must be in the range of ${MINIMUM_LOTTO_NUMBER} to ${MAXIMUM_LOTTO_NUMBER}."
        }
    }

    val numbers get() = _numbers.toList()

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
