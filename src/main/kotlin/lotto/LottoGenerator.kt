package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun createRandomLottos(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}