package lotto.service

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms

object GenerateLottos {
    fun generate(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .sorted()
            Lotto(numbers)
        }
    }
}