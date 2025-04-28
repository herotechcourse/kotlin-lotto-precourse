package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.LOTTO_SIZE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

class LottoGame {
    fun getQuantity(amount: Int): Int = amount / LOTTO_COST

    fun issueLottoTickets(quantity: Int): List<Lotto> = List(quantity) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_SIZE,
            ).sorted()
        )
    }
}
