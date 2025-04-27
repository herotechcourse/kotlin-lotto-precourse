package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {

    private const val TICKET_PRICE = 1000

    fun purchaseLottos(amount: Int): List<Lotto> {
        if (amount % TICKET_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
        val count = amount / TICKET_PRICE
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}