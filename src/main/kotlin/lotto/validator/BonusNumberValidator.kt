package lotto.validator

object BonusNumberValidator {
    fun validate(bonusNumber: String, numbers: List<String>) {
        if (numbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] Bonus number must be different from the winning numbers.")
        }

        val bonusNumber = bonusNumber.toIntOrNull()

        if (bonusNumber == null) {
            throw IllegalArgumentException("[ERROR] Bonus number must be numeric value.")
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
    }
}
