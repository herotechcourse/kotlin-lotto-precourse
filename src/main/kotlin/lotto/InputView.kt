package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun validateLottoNumber(input: String) {
        var num: Int
        try {
            num = input.toInt()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Provided input is not an integer.")
        }
        if (num < 1 || num > 45) {
            throw IllegalArgumentException("[ERROR] Lotto number must be between from 1 and 45.")
        }
    }

    fun validatePurchaseAmount(input: String) {
        var num: Int
        try {
            num = input.toInt()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Provided input is not an integer.")
        }
        if (num % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount has to be divisible by 1,000.")
        }
    }



    fun getPurchaseAmount() {
        val purchase = Console.readLine()
        try {
            validatePurchaseAmount(purchase)
        }
        catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
        LotteryTicketMachine.purchaseAmount = purchase.toInt()
    }

    fun getWinningNumbers() {
        val winningStrings = Console.readLine().split(",")
        for (input in winningStrings) {
            validateLottoNumber(input)
            LotteryTicketMachine.winningNumbers.add(input.toInt())
        }
        println()
    }

    fun getBonusNumber() {
        val input = Console.readLine()
        validateLottoNumber(input)
        LotteryTicketMachine.bonusNumber = input.toInt()
        println()
    }
}