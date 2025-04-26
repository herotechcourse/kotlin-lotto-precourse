package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}