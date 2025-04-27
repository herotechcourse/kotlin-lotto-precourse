package lotto.utils

object Validator {
    fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1000.")
        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: error() }
        if (numbers.size != 6 || numbers.distinct().size != 6) error()
        if (numbers.any { it !in 1..45 }) error()
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull() ?: error()
        if (number !in 1..45) error()
        return number
    }

    private fun error(): Nothing = throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45 and unique.")
}
