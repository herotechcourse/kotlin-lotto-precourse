package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun run(count: Int): List<Lotto> {
        require(count > 0) { Configuration.ErrorMessages.LOTTO_COUNT_INVALID }

        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(Configuration.MIN_NUMBER, Configuration.MAX_NUMBER, Configuration.LOTTO_COUNT)
            Lotto(numbers)
        }
    }
}