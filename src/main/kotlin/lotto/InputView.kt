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
            try {
                validateLottoNumber(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                getWinningNumbers()
            }
            LotteryTicketMachine.winningNumbers.add(input.toInt())
        }
    }

    fun getBonusNumber() {
        val input = Console.readLine()
        try {
            validateLottoNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getBonusNumber()
        }
        LotteryTicketMachine.bonusNumber = input.toInt()
    }
}