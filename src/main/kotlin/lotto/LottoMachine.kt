package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    private const val TICKET_PRICE = 1000

    fun createLottos(money: Int): List<Lotto> {
        val count = money / TICKET_PRICE
        return List(count) {
            // the test harness will inject exactly these lists in order
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(nums)
        }
    }
}
