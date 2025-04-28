package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateLottos(purchaseAmount: Int): List<Lotto> {
        validatePurchaseAmount(purchaseAmount)
        val numberOfTickets = purchaseAmount / 1000
        return List(numberOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers.sorted())
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1,000." }
    }
}