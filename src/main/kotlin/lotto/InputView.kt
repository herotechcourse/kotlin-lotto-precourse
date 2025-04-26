package lotto

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun inputAmountOfPurchase(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val budget = Console.readLine()?.trim()?.toIntOrNull()
                    ?: throw IllegalArgumentException("Invalid purchase amount. Please enter a valid number amount.")

                if (budget < 1000) throw IllegalArgumentException("Insufficient budget.(one Lotto is 1000)")

                return budget / 1000
            } catch (e: IllegalArgumentException) {
                println("[ERROR] " + (e.message ?: "Invalid purchase amount."))
            }
        }
    }

    fun inputWinningNumbers(): Lotto {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val winningNumbers =
                    Console.readLine()?.split(",") ?: throw IllegalArgumentException()

                val validatedWinningNumbers = validateWinningNumbers(winningNumbers)
                return validatedWinningNumbers
            } catch (e: IllegalArgumentException) {
                println("[ERROR] " + (e.message ?: "Invalid winning numbers."))
            }
        }
    }

    private fun validateWinningNumbers(winningNumbers: List<String>): Lotto {
        val numbers = winningNumbers.map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("Invalid number found.")
        }

        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("Each number must be between 1 and 45.")
        }

        if (numbers.size != 6) {
            throw IllegalArgumentException("Please enter exactly 6 numbers.")
        }
        val unique = numbers.toSet()
        if (unique.size != 6) {
            throw IllegalArgumentException("Please provide 6 unique numbers")
        }

        return Lotto(numbers.sorted())
    }

    fun inputBonusNumber(winningNumbers: Lotto): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonusNumber =
                    Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("Invalid bonus number.")

                return validateBonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] " + (e.message ?: "Invalid bonus number."))
            }
        }
    }


    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: Lotto): Int {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("Number must be between 1 and 45.")
        }

        if (winningNumbers.containsNumber(bonusNumber)) {
            throw IllegalArgumentException("Bonus number cannot be one of the winning numbers.")
        }

        return bonusNumber
    }
}
