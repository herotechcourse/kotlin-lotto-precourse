package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount() {
        val purchase = Console.readLine().toInt()
        LotteryTicketMachine.purchaseAmount = purchase
    }
}