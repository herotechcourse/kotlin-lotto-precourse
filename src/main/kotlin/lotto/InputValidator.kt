package lotto

class InputValidator {
    fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull() ?:
        throw ValidationException("The purchase amount must be a number.")

        require(amount > 0) { "The purchase amount must be positive." }
        require(amount % 1000 == 0) { "The purchase amount must be divisible by 1000." }

        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim() }

        require(numbers.size == 6) { "You must enter exactly 6 numbers." }

        val winningNumbers = numbers.map {
            it.toIntOrNull() ?: throw ValidationException("All winning numbers must be numbers.")
        }

        require(winningNumbers.size == winningNumbers.distinct().size) { "Winning numbers must be unique." }

        winningNumbers.forEach {
            require(it in 1..45) { "Numbers must be between 1-45." }
        }

        return winningNumbers.sorted()
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val bonusNumber = input.toIntOrNull() ?:
        throw ValidationException("The bonus number must be a number.")

        require(bonusNumber in 1..45) { "Bonus number must be between 1-45." }

        require(bonusNumber !in winningNumbers) { "The bonus number must be unique from winning numbers." }

        return bonusNumber
    }
}

class ValidationException(message: String) : IllegalArgumentException(message)