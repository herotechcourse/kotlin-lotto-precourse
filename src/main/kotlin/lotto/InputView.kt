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
            LotteryTicketMachine.purchaseAmount = purchase.toInt()
        }
        catch (e: IllegalArgumentException) {
            println(e.message)
            OutputView.askForPurchaseAmount()
        }
    }

    fun getWinningNumbers() {
        val winningStrings = Console.readLine().split(",")
        for (input in winningStrings) {
            try {
                validateLottoNumber(input)
                LotteryTicketMachine.winningNumbers.add(input.toInt())
            } catch (e: IllegalArgumentException) {
                println(e.message)
                OutputView.askForWinningNumbers()
            }
        }
    }

    fun getBonusNumber() {
        val input = Console.readLine()
        try {
            validateLottoNumber(input)
            LotteryTicketMachine.bonusNumber = input.toInt()
            LotteryTicketMachine.validateBonusNumber(LotteryTicketMachine.winningNumbers, LotteryTicketMachine.bonusNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            OutputView.askForBonusNumber()
        }
    }
}