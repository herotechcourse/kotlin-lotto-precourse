package lotto.service

import lotto.models.Lotto
import camp.nextstep.edu.missionutils.Randoms

object LottoManager {
    fun generateLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun generateMultipleTickets(amount: Int): List<Lotto> {
        return List(amount) { generateLottoTicket() }
    }
}