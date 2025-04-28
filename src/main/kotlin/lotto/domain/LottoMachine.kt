package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
    fun buy(purchaseAmount: PurchaseAmount): List<Lotto> =
        List(purchaseAmount.ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
}
