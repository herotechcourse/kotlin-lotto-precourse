package lotto.ui

import lotto.Lotto
import lotto.PurchaseAmount

object OutputView {
    private const val PURCHASED_TICKETS_MESSAGE = "You have purchased %d tickets."

    fun printLotteryTicketsOutputMessage(purchaseAmount: PurchaseAmount, lottoList: List<Lotto>) {
        println()
        println(PURCHASED_TICKETS_MESSAGE.format(purchaseAmount.ticketCount))
        lottoList.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }
}