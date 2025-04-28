package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun issueLotto(count: Int) : List<LottoTicket> {
        return List(count) {
            LottoTicket(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}
