package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import java.util.*

class PurchasedLotto(val lottoNumbers: List<Int>) {
    companion object {
        fun generateLottoNumbers(ticketCount: Int): List<PurchasedLotto> {
            return List(ticketCount) { createPurchasedLotto() }
        }

        private fun createPurchasedLotto(): PurchasedLotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Collections.sort(numbers)
            return PurchasedLotto(numbers)
        }
    }
}