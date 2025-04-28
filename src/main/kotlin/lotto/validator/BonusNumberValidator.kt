package lotto.validator

object BonusNumberValidator {
    fun validate(bonusNumber: String, numbers: List<String>) {
        if (bonusNumber.toIntOrNull()==null){
            throw IllegalArgumentException("[ERROR] Bonus number must be numeric value.")
        }
        if (numbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] Bonus number must be different from the winning numbers.")
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
    }
}