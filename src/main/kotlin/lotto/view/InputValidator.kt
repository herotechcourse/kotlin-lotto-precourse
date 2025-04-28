package lotto.view

object InputValidator {
    private const val ERROR_INVALID_AMOUNT = "[ERROR] Purchase amount must be a valid number."
    private const val ERROR_INVALID_NUMBER = "[ERROR] Input must be a valid number."
    private const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] Bonus number must be a valid number."

    fun validateAmount(input: String?): Int {
        return input?.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_AMOUNT)
    }

    fun validateWinningNumbers(input: String?): List<Int> {
        return input?.split(",")
            ?.map { it.trim() }
            ?.map { it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER) }
            ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
    }

    fun validateBonusNumber(input: String?): Int {
        return input?.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER)
    }
}
