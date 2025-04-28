package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGenerator {
    fun generate(ticketCount: Int): Lottos {
        val tickets = List(ticketCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBER_SIZE
            )
            Lotto(lottoNumbers)
        }

        return Lottos(tickets)
    }
}