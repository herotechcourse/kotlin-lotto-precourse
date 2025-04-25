package lotto

import camp.nextstep.edu.missionutils.Console

object InputValidator {

    // Validates that the purchase amount is a number and divisible by 1000
    fun validatePurchaseAmount(amount: String): Int {
        return amount.toIntOrNull()?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("Amount must be a number divisible by 1000.")
    }

    // Validates that all winning numbers are unique and within the range 1-45
    fun validateWinningNumbers(numbers: String): List<Int> {
        val numList = numbers.split(",").mapNotNull { it.trim().toIntOrNull() }
        if (numList.size != 6) {
            throw IllegalArgumentException("Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        val uniqueNumbers = numList.toSet()
        if (uniqueNumbers.size != 6) {
            throw IllegalArgumentException("Winning numbers must be unique.")
        }
        if (uniqueNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("Numbers must be between 1 and 45.")
        }
        return uniqueNumbers.toList() // Convert Set to List here
    }

    // Validates that the bonus number is unique and not part of the winning numbers
    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>): Int {
        val bonus = bonusNumber.toIntOrNull()
        if (bonus == null || bonus !in 1..45) {
            throw IllegalArgumentException("Bonus number must be between 1 and 45.")
        }
        if (winningNumbers.contains(bonus)) {
            throw IllegalArgumentException("Bonus number must not be part of the winning numbers.")
        }
        return bonus
    }

}
