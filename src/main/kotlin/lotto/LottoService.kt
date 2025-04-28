package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoService {
    fun generateLottos(purchaseAmount: Int): List<Lotto> {
        val numberOfTickets = purchaseAmount / 1000
        return List(numberOfTickets) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }
}