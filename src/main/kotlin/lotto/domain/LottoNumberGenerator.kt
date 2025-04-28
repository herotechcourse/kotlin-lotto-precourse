package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

interface LottoNumberGenerator {
    fun generate(): List<Int>
}

class RandomNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
    }
}
