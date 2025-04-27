package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.constants.LottoConstants

object LottoGenerator {

    fun generate(amount: Int): List<Lotto> {
        val count: Int = amount / LottoConstants.TICKET_PRICE
        val lottos: List<Lotto> = List(count) { generateLotto() }

        return lottos
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoConstants.MIN_NUMBER,
            LottoConstants.MAX_NUMBER,
            LottoConstants.LOTTO_SIZE
        )
        return Lotto(numbers)
    }
}