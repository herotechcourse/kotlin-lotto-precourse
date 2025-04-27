package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.LottoConstants.MAX_LOTTO_NUMBER
import lotto.LottoConstants.MIN_LOTTO_NUMBER

class RandomNumbersStrategy : GenerateStrategy {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)
    }
}
