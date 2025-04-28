package lotto.generator

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.common.Constants

object LottoGenerator {
    fun generate(): Lotto {
        return Lotto(
            Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_SIZE
            )
        )

    }
}