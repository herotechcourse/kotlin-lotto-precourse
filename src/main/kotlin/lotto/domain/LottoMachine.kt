package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
  fun buyLottoTickets(purchaseAmount: Int): List<LottoTicket>{
      val ticketCount = purchaseAmount / 1000
      return List(ticketCount) {
        LottoTicket(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
      }
  }
}

