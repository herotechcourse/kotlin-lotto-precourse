package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

private const val LOTTO_PRICE = 1000
private const val LOTTO_NUMBER_COUNT = 6
private const val LOTTO_MIN_NUMBER = 1
private const val LOTTO_MAX_NUMBER = 45

class CreateController {
  fun createLottoTickets(ticketAmount: Int): List<Lotto> {
    val ticektCount = ticketAmount / 1000
    return List(ticektCount) { 
      Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)) 
    }
  }
}