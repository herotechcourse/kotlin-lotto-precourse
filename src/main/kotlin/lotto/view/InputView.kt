package lotto.view

import camp.nextstep.edu.missionutils.Console
import java.lang.Integer.parseInt

class InputView {
    companion object {
        fun moneyInput(): Int {
            println("Please enter the purchase amount.")
            while (true) {
                val input = Console.readLine() ?: ""
                try {
                    val numericInput = validateInputIsNumeric(input)
                    return validateMoneyRange(numericInput)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        fun winningNumberInput(): List<Int> {
            println("Please enter last week's winning numbers.")
            while (true) {
                val input = Console.readLine() ?: ""
                try {
                    return validateWinningNumber(input)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        fun bonusNumberInput(): Int {
            println("Please enter the bonus number.")
            while (true) {
                val input = Console.readLine() ?: ""
                try {
                    val bonusNumber = validateInputIsNumeric(input)
                    return validateBonusNumberRange(bonusNumber)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun validateMoneyRange(inputMoney: Int): Int {
            if (inputMoney !in 1000..100000) {
                throw IllegalArgumentException("[ERROR] The purchase amount must be between 1,000KRW and 100,000KRW.")
            }
            return inputMoney
        }

        private fun validateInputIsNumeric(input: String): Int {
            return runCatching { parseInt(input) }
                .getOrElse {
                    throw IllegalArgumentException("[ERROR] Only numeric values are allowed.")
                }
        }


        private fun validateWinningNumber(input: String): List<Int> {
            val winningNumber = validateWinningNumberIsNumeric(input)
            return validateWinningNumberRange(winningNumber)

        }

        private fun validateWinningNumberIsNumeric(input: String): List<Int> {
            val winningNumber = input.split(",")
                .map { it.trim() }
                .map {
                    it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Only numeric values are allowed.")
                }
            return winningNumber
        }

        private fun validateWinningNumberRange(winningNumber: List<Int>): List<Int> {
            if (winningNumber.any { it !in 1..45 }) {
                throw IllegalArgumentException("[ERROR] winning numbers must be between 1 and 45.")
            }
            return winningNumber
        }

        fun validateBonusNumberRange(bonusNumber: Int): Int {
            if (bonusNumber !in 1..45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            return bonusNumber
        }

    }


}