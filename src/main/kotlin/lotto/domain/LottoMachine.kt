package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.LottoConstants.MAX_NUMBER
import lotto.LottoConstants.MIN_NUMBER
import lotto.LottoConstants.NUMBERS_PER_TICKET

class LottoMachine {
    fun buy(purchaseAmount: PurchaseAmount): List<Lotto> =
        List(purchaseAmount.ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_TICKET))
        }
}
