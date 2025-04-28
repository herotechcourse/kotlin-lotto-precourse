package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun validatePositiveInteger(input: String) {
        var num = 0
        try {
            num = input.toInt()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Provided input is not an integer.")
        }
        if (num < 1) {
            throw IllegalArgumentException("[ERROR] Provided input is not a positive integer.")
        }
    }

    fun getPurchaseAmount() {
        val purchase = Console.readLine()
        validatePositiveInteger(purchase)
        LotteryTicketMachine.purchaseAmount = purchase.toInt()
    }

    fun getWinningNumbers() {
        val winningStrings = Console.readLine().split(",")
        for (input in winningStrings) {
            validatePositiveInteger(input)
            LotteryTicketMachine.winningNumbers.add(input.toInt())
        }
        println()
    }

    fun getBonusNumber() {
        val input = Console.readLine()
        validatePositiveInteger(input)
        LotteryTicketMachine.bonusNumber = input.toInt()
        println()
    }
}