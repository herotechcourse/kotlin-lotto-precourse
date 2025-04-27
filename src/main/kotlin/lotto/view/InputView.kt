package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

object InputView {
    fun purchaseAmount(): Int {
        println("Purchase amount for lottery tickets:")
        val input = Console.readLine()

        return parseInteger(input)
    }

    fun inputWinningsNumbers(): List<Int> {
        println("Winning numbers (comma-separated):")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { parseInteger(it) }
        Lotto.validateNumbers(numbers)

        return numbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println("Bonus number:")
        val input = Console.readLine()
        val bonusNumber = parseInteger(input)
        validateBonusNumber(bonusNumber, winningNumbers)

        return bonusNumber
    }

    private fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        require(bonus in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }
        require(bonus !in winningNumbers) {
            "[ERROR] Bonus number must not be among the winning numbers."
        }
    }

    private fun parseInteger(input: String) = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] invalid input")
}