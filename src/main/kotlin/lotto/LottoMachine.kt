package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generate(count: Int): List<LottoTicket> =
        List(count) { LottoTicket(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))) }
}
