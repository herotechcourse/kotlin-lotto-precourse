package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = InputValidator()

    fun readBudget(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                validator.validateBudget(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(LottoMessages.tryAgainDivisible)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                validator.validateWinningNumbers(input)
                val inputNumbers = input.split(",").map { it.trim().toInt() }
                return inputNumbers
            } catch (e: IllegalArgumentException) {
                println(LottoMessages.invalidWinningNumbers)
            }
        }
    }
}