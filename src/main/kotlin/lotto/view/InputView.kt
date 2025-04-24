package lotto.view

import lotto.domain.Bonus
import lotto.domain.Lotto

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readln()
        checkIfNumberIsValid(input)
        return input.toInt()
    }

    fun readWinningLotto(): Lotto {
        println("You have purchased 8 tickets.")
        val input = readln()
        checkIfWinningLottoIsValid(input)
        val numbers = input.split(",").map { it.toInt() }
        return Lotto(numbers)
    }

    fun readBonus(): Bonus {
        println()
        println("Please enter the bonus number.")
        val input = readln()
        checkIfNumberIsValid(input)
        return Bonus(input.toInt())
    }

    private fun checkIfNumberIsValid(input: String) {
        isInputEmpty(input)
        isNumeric(input)
    }

    private fun checkIfWinningLottoIsValid(input: String) {
        isInputEmpty(input)
        isInputFormatValid(input)
        input.split(",").forEach { value ->
            isInputEmpty(value)
            isNumeric(value)
        }
    }

    private fun isInputEmpty(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Please enter a value.")
        }
    }

    private fun isInputFormatValid(input: String) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw IllegalArgumentException("[ERROR] Invalid input format.")
        }
    }

    private fun isNumeric(input: String) {
        if (!input.matches(Regex("^[1-9][0-9]*$"))) {
            throw IllegalArgumentException("[ERROR] Input must be a valid number.")
        }
    }
}
