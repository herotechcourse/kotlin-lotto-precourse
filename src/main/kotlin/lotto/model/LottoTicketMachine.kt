package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoTicketMachine {
    fun buyLotto(quantity: Int) : List<Lotto> {
        val lottoTicket : MutableList<Lotto> = mutableListOf()
        for(i in 1..quantity) {
            lottoTicket.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }
        return lottoTicket
    }
}
