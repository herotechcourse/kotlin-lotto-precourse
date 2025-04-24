package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }

}