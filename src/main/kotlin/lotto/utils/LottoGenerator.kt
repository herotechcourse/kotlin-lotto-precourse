package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}