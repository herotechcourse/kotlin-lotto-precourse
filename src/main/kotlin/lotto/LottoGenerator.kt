package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN

object LottoGenerator {
    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { generateSingleLotto() }
    }

    private fun generateSingleLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
            .sorted()
        return Lotto(numbers)
    }
}