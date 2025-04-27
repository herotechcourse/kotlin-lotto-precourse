package lotto

import camp.nextstep.edu.missionutils.Randoms

object TicketMachine {
  private const val TICKET_PRICE = 1000

  fun issueTickets(amount: Int): List<Lotto> {
    require(amount > 0 && amount % TICKET_PRICE == 0) { "[ERROR] Amount must be a positive multiple of 1,000." }
    return List(amount / TICKET_PRICE) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
  }
}