package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

interface LottoNumberGenerator {
    fun generate(): List<Int>
}

class RandomNumberGenerator : LottoNumberGenerator{
    override fun generate(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}