package lotto

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        for (number in numbers) {
            require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] Lotto number must be between 1 and 45." }
        }
    }

    fun matchLotto(winningLotto: WinningLotto): LottoResultType {
        return winningLotto.evaluateLotto(this.numbers)
    }

    override fun toString(): String {
        return numbers.toString()
    }

}
