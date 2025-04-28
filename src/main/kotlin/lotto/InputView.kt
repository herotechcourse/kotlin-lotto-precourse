package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun <T> promptUntilValid(prompt: () -> T): T {
        while (true) {
            try {
                return prompt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readPurchaseAmount(): Int {
        return promptUntilValid {
            println("Please enter the purchase amount.")
            val purchaseAmount = Console.readLine().toIntOrNull()

            requireNotNull(purchaseAmount) { "[ERROR] purchase amount must be an integer" }
            require(purchaseAmount > 0) { "[ERROR] amount must be a positive number." }
            require(purchaseAmount % 1000 == 0) { "[ERROR] Each ticket costs 1,000 KRW" }
            purchaseAmount
        }
    }

    fun readWinningNumbers(): List<Int> {
        return promptUntilValid {
            println("Please enter last week's winning numbers. (comma-separated)")
            val winningNumbers = Console.readLine().split(",")
                .map { requireNotNull(it.trim().toIntOrNull()) { "[ERROR] Winning numbers must be integers." } }

            require(winningNumbers.size == 6) { "[ERROR] Exactly 6 numbers must be entered." }
            require(winningNumbers.toSet().size == winningNumbers.size) { "[ERROR] Duplicate numbers are not allowed." }
            require(winningNumbers.all { it >= 1 && it <= 45 }) { "[ERROR] Numbers must be between 1 and 45." }
            winningNumbers
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        return promptUntilValid {
            println("Please enter the bonus number.")
            val bonusNumber = Console.readLine().toIntOrNull()

            requireNotNull(bonusNumber) { "[ERROR] Bonus number must be an integer." }
            require(bonusNumber >= 1 && bonusNumber <= 45) { "[ERROR] Numbers must be between 1 and 45." }
            require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number must not duplicate winning numbers." }

            bonusNumber
        }
    }
}