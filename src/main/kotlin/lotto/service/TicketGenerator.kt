package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.core.constant.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.core.constant.LottoConstants.MAX_LOTTO_NUMBER
import lotto.core.constant.LottoConstants.MIN_LOTTO_NUMBER

class TicketGenerator {
    fun generate(count: Int): List<Lotto> =
        List(count) {
            Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
                .sorted()
                .let(::Lotto)
        }
}