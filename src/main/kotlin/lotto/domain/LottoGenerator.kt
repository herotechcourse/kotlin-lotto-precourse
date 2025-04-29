package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
  fun generateLotto(): Lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
  fun generateTickets(count: Int): List<Lotto> = List(count) { generateLotto() }
}
