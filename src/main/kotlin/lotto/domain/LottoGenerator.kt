package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGenerator {
    fun generate(ticketCount: Int): Lottos {
        val tickets = List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT))
        }

        return Lottos(tickets)
    }

    private const val MIN_LOTTO_NUMBER: Int = 1
    private const val MAX_LOTTO_NUMBER: Int = 45
    private const val LOTTO_NUMBER_COUNT: Int = 6
}