package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.LOTTO_COUNT
import lotto.config.MAX_LOTTO_NUMBER
import lotto.config.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions


    companion object {
        fun generateLotto(): Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT))
        }

        fun generateLottoArray(ticketAmount: Int): Array<Lotto> {
            return Array(ticketAmount) { generateLotto() }
        }
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }
}
