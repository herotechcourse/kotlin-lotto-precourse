package lotto.model.random

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto.Companion.LOTTO_NUMBER_SIZE
import lotto.Lotto.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.Lotto.Companion.MINIMUM_LOTTO_NUMBER

class DefaultRandomNumbersGenerator: RandomNumbersGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
    }
}
