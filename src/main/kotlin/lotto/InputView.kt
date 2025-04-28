package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount() {
        val purchase = Console.readLine().toInt()
        LotteryTicketMachine.purchaseAmount = purchase
    }

    fun getWinningNumbers() {
        val winningStrings = Console.readLine().split(",")
        for (num in winningStrings) {
            LotteryTicketMachine.winningNumbers.add(num.toInt())
        }
        println()
    }

    fun getBonusNumber() {
        val number = Console.readLine().toInt()
        LotteryTicketMachine.bonusNumber = number
        println()
    }
}