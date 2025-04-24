package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun requestPurchaseAmount(): Int {
        while (true) {
            val input = readAmountInput()
            if (input != null) return input
        }
    }

    private fun readAmountInput(): Int? {
        return try {
            val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input is required.")
            val amount = input.toInt()
            if (amount % 1000 != 0) {
                println("[ERROR] Amount must be divisible by 1000.")
                null
            } else {
                amount
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] Amount must be a number.")
            null
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    fun requestWinningNumbers(): List<Int> {
        while (true) {
            val input = readWinningNumbersInput()
            if (input != null) return input
        }
    }

    private fun readWinningNumbersInput(): List<Int>? {
        try {
            println("Please enter the winning numbers (comma-separated):")
            val input = Console.readLine()?.split(",")?.map { it.trim().toInt() }
                ?: throw IllegalArgumentException("[ERROR] Invalid input")

            if (input.size != 6 || input.any { it !in 1..45 }) {
                println("[ERROR] Winning numbers must be 6 numbers between 1 and 45.")
                return null
            }
            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return null
        } catch (e: NumberFormatException) {
            println("[ERROR] Winning numbers must be valid integers.")
            return null
        }
    }

    fun requestBonusNumber(): Int {
        while (true) {
            val input = readBonusNumberInput()
            if (input != null) return input
        }
    }

    private fun readBonusNumberInput(): Int? {
        try {
            println("Please enter the bonus number:")
            val input = Console.readLine()?.toInt()
                ?: throw IllegalArgumentException("[ERROR] Invalid input")

            if (input !in 1..45) {
                println("[ERROR] Bonus number must be between 1 and 45.")
                return null
            }
            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return null
        } catch (e: NumberFormatException) {
            println("[ERROR] Bonus number must be a valid integer.")
            return null
        }
    }
}
