package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Lotto.SIZE) { "[ERROR] Lotto must contain exactly ${Lotto.SIZE} numbers." }
    }

    // TODO: Implement additional functions
    companion object {
        private const val FIRST_NUM = 1
        private const val LAST_NUM = 45
        const val SIZE = 6
        const val COST = 10000

        fun getLottoNumbers(): Lotto = Lotto(Randoms.pickUniqueNumbersInRange(Lotto.FIRST_NUM,Lotto.LAST_NUM,Lotto.SIZE))

    }
}
