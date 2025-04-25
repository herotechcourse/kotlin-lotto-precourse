package view

import camp.nextstep.edu.missionutils.Console

object Input {
    fun readPurchaseAmountSafely(): Int {
        while (true) {
            try {
                return readPurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbersSafely(): List<Int> {
        while (true) {
            try {
                return readWinningNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumberSafely(): Int {
        while (true) {
            try {
                return readBonusNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readPurchaseAmount(): Int {
        val input = Console.readLine()
        validateNumberFor(input, "Purchase amount")

        val purchaseAmount = input.toInt()
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than 0." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1000." }

        return purchaseAmount
    }

    private fun readWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val regex = Regex("^[0-9]+(,[0-9]+)*$")
        require(input.matches(regex)) { "[ERROR] Only comma-separated numbers allowed." }

        val numbers = input.split(",").map { it.toInt() }
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }

        return numbers
    }

    private fun readBonusNumber(): Int {
        val input = Console.readLine()
        validateNumberFor(input, "Bonus number")

        val bonusNumber = input.toInt()
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return bonusNumber
    }

    private fun validateNumberFor(input: String, inputType: String) {
        val regex = Regex("^[0-9]+$")
        require(input.matches(regex)) { "[ERROR] $inputType must be a valid number." }
    }
}
