package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoService {
    fun generateTickets(count: Int): List<Lotto> {
        return List(count, fun(_: Int): Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        })
    }
}



