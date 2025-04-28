package lotto.validator

object WinningNumbersValidator {
    fun validate(winningNumbers: List<String>) {
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must contain exactly 6 numbers.")
        }

        if (winningNumbers.distinct().size != winningNumbers.size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }

        for (number in winningNumbers) {
            val num = number.toIntOrNull()
            if (num == null) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be numeric values.")
            }
            if (num < 1 || num > 45) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
            }
        }

    }
}