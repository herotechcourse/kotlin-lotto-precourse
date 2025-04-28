package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants

class RandomLottoGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.LOTTO_NUMBER_COUNT)
        return numbers.sorted()
    }
}