package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("\nPlease enter the purchase amount:")
        val input = Console.readLine().trim()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter the winning numbers (comma-separated):")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG) }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter a bonus number:")
        val input = Console.readLine()
        val number = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG)
        return number
    }

    companion object {
        private const val INVALID_INPUT_MSG = "[ERROR] Invalid input."
    }
}