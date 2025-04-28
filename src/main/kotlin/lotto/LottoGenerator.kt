package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
}