package lotto

import lotto.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    // TODO: Implement additional functions
    fun getNumbers() = numbers
}
