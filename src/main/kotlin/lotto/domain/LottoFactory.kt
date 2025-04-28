package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoFactory {

    fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()
        return Lotto(numbers)
    }

    fun createLottos(count: Int): List<Lotto> {
        return List(count) { createLotto() }
    }
}