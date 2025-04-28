package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun <T> promptUntilValid(message: String, prompt: () -> T): T {
        while (true) {
            try {
                println(message)
                return prompt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun readPurchaseAmount(): Int {
        return promptUntilValid("Please enter the purchase amount.") {
            val purchaseAmount = Console.readLine().toIntOrNull()
            requireNotNull(purchaseAmount) { "purchase amount must be an integer" }
            LottoValidators.validatePurchase(purchaseAmount)
            println()
            purchaseAmount

        }
    }

    fun readWinningNumbers(): List<Int> {
        return promptUntilValid("Please enter last week's winning numbers. (comma-separated)") {
            val winningNumbers = Console.readLine().split(",")
                .map { requireNotNull(it.trim().toIntOrNull()) { "Winning numbers must be integers." } }
            LottoValidators.validateWinningNumber(winningNumbers)
            println()
            winningNumbers
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        return promptUntilValid("Please enter the bonus number.") {
            val bonusNumber = Console.readLine().toIntOrNull()
            requireNotNull(bonusNumber) { "Bonus number must be an integer." }
            LottoValidators.validateBonusNumber(bonusNumber, winningNumbers)
            println()
            bonusNumber
        }
    }
}