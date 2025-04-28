package lotto.domain.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.LottoConstants.LOTTO_NUMBER_ENDS
import lotto.config.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.config.LottoConstants.LOTTO_NUMBER_STARTS
import lotto.config.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_STARTS, LOTTO_NUMBER_ENDS, LOTTO_NUMBER_SIZE)
    }
}