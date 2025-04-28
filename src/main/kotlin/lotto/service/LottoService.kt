package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto

object LottoService {
    fun generateTickets(amount: Int): List<Lotto> {
        val count = amount / 1_000
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }
}
