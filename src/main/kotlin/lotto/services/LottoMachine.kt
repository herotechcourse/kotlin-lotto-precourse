package lotto.services

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto


object LottoMachine {
    fun issueLottos(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / 1000
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }
}