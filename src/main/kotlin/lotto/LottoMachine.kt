package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun buyLottos(purchaseAmount: Int): List<Lotto> {
        validatePurchaseAmount(purchaseAmount)
        val numberOfTickets = purchaseAmount / 1000
        return List(numberOfTickets) { Lotto(generateNumbers()) }
    }

    private fun validatePurchaseAmount(purchaseAmount: Int) {
        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("Purchase amount must be divisible by 1000.")
        }
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}