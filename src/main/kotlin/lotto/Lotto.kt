package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(val numbers: List<Int>, val bonusNumber: Int = 0) {
    init {
        require(numbers.size == SIZE) { "[ERROR] Lotto must contain exactly ${SIZE} numbers." }
    }

    // TODO: Implement additional functions
    companion object {
        private const val FIRST_NUM = 1
        private const val LAST_NUM = 45
        const val SIZE = 6
        const val COST = 10000

        fun getLottoNumbers(): Lotto = Lotto(Randoms.pickUniqueNumbersInRange(FIRST_NUM, LAST_NUM, SIZE))

    }
}
