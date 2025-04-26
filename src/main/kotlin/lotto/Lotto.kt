package lotto

import lotto.model.LOTTO_NUMBER_MAX
import lotto.model.LOTTO_NUMBER_MIN
import lotto.model.LOTTO_SIZE

class Lotto(
    private val numbers: List<Int>
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == LOTTO_SIZE) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) {
            "[ERROR] Lotto numbers must be between $LOTTO_NUMBER_MIN and $LOTTO_NUMBER_MAX."
        }
    }

    fun numbers(): List<Int> = numbers.toList()
}
