package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getInput(type: InputType, winningNumbers: List<Int> = listOf()): Any {
        while (true) {
            try {
                return when (type) {
                    InputType.PURCHASE_AMOUNT -> getPurchaseAmount()
                    InputType.WINNING_NUMBERS -> getWinningNumbers()
                    InputType.BONUS_NUMBER -> getBonusNumber(winningNumbers)
                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println("Please try again.\n")
            }
        }
    }

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")

        try {
            val input = Console.readLine()?.trim()?.toInt()
                ?: throw IllegalStateException("[ERROR] Input cannot be null.\n")

            return input
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid integer\n")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")

        try {
            val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null\n")

            val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }.toList()

            if (numbers.size != 6 || numbers.size != numbers.distinct().size || checkNumbers(numbers)) {
                throw IllegalArgumentException("[ERROR] You must enter exactly 6, non duplicate numbers.\n")
            }

            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Winning Numbers are not a valid numbers.\n")
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")

        try {
            val input = Console.readLine()?.trim()?.toInt() ?: throw IllegalArgumentException("[ERROR] Input cannot be null\n")

            if (!isValidLottoNumber(input) || input in winningNumbers) {
                throw IllegalArgumentException("[ERROR] bonus number must be between 1 and 45, not in winningNumbers.\n")
            }

            println()

            return input
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid number\n")
        }
    }

    fun isValidLottoNumber(number: Int): Boolean {
        if (number < 1 || number > 45) {
            return false
        }
        return true
    }

    fun checkNumbers(numbers: List<Int>): Boolean {
        numbers.forEach { number ->
            if (!isValidLottoNumber(number)) {
                return false
            }
        }
        return true
    }

    enum class InputType {
        PURCHASE_AMOUNT, WINNING_NUMBERS, BONUS_NUMBER
    }
}