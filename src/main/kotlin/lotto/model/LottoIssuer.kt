package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.constants.Constants

object LottoIssuer {
    fun execute(count: Int): List<Lotto> {
        return List(count) {
            val numbers =
                Randoms.pickUniqueNumbersInRange(
                    Constants.LOTTO_MIN_NUMBER,
                    Constants.LOTTO_MAX_NUMBER,
                    Constants.LOTTO_NUMBERS_COUNT
                )
            Lotto(numbers.sorted())
        }
    }
}