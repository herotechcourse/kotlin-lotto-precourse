package lotto

object LottoValidators {
    fun validatePurchase(amount: Int) {
        require(amount > 0) { "[ERROR] amount must be a positive number." }
        require(amount % 1_000 == 0) { "[ERROR] Each ticket costs 1,000 KRW" }
    }

    fun validateWinningNumber(numbers: List<Int>) {
        require(numbers.size == 6) { "Exactly 6 numbers must be entered." }
        require(numbers.toSet().size == 6) { "Duplicate numbers are not allowed." }
        require(numbers.all { it in 1..45 }) { "Numbers must be between 1 and 45." }
    }

    fun validateBonusNumber(bonus: Int, winning: Collection<Int>) {
        require(bonus !in winning) { "[ERROR] Bonus number must not duplicate winning numbers." }
        require(bonus in 1..45) { "[ERROR] Numbers must be between 1 and 45." }
    }
}