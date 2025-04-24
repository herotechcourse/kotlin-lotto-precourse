package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoIssuer {
    fun execute(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers.sorted())
        }
    }
}