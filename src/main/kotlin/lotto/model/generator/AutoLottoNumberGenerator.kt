package lotto.model.generator

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.LOTTO_NUMBER_MAX
import lotto.model.LOTTO_NUMBER_MIN
import lotto.model.LOTTO_SIZE

class AutoLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            LOTTO_NUMBER_MIN,
            LOTTO_NUMBER_MAX,
            LOTTO_SIZE
        )
    }
}
