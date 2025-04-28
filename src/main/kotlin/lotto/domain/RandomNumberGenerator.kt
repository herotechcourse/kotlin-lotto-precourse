package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_ENDS
import lotto.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.LottoConstants.LOTTO_NUMBER_STARTS
import lotto.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_STARTS, LOTTO_NUMBER_ENDS, LOTTO_NUMBER_SIZE)
    }
}