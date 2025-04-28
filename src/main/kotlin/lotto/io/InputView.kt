package lotto.io

import camp.nextstep.edu.missionutils.Console
import lotto.common.Constants

object InputView {
    fun inputPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        try {
            val intAmount = Console.readLine().toInt()
            if (intAmount % Constants.TICKET_PRICE != 0) {
                throw IllegalArgumentException("Amount must be divisible by 1000.")
            }
            if (intAmount < 0) {
                throw IllegalArgumentException("Amount must be positive.")
            }
            return intAmount / Constants.TICKET_PRICE
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return inputPurchaseAmount()
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        try {
            return Console.readLine().split(",").map { it.trim().toInt() }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return inputWinningNumbers()
        }
    }

    fun inputBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        try {
            return Console.readLine().toInt()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return inputBonusNumber()
        }
    }
}