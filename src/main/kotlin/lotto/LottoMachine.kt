package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    companion object {
        const val TICKET_PRICE = 1_000
    }

    fun issue(amount: Int): List<Lotto> {
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Purchase amount must be divisible by $TICKET_PRICE."
        }
        val count = amount / TICKET_PRICE
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}
