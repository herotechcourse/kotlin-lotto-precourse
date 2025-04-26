package lotto

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

class Lotto(private val numbers: List<Int>): LottoMatchable{
    init {
        require(numbers.size == COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        for (number in numbers) {
            require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] Lotto number must be between 1 and 45." }
        }
    }

    override fun matchLotto(lottoEvaluator: LottoEvaluator): LottoResultType {
        return lottoEvaluator.evaluateLotto(this.numbers)
    }

    override fun toString(): String {
        return numbers.toString()
    }

}
