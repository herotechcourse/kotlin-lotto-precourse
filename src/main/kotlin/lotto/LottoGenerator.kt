package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun run(count: Int): List<Lotto> {
        require(count > 0) { "[ERROR] Lotto count must be greater than 0." }

        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT)
            Lotto(numbers)
        }
    }
}