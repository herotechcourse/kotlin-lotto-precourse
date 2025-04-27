package lotto

class PurchaseAmountValidator {
    fun validatePurchaseAmount(purchaseAmount: Int?) {
        require (purchaseAmount != null && purchaseAmount % 1000 == 0 && purchaseAmount > 0) {
            throw IllegalArgumentException("[ERROR] Invalid purchase amount. " +
                    "Input must be greater than zero and divisible by 1,000")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] Exactly 6 numbers must be entered." }
        require(numbers.distinct().size == 6) { "[ERROR] Numbers must be unique." }
        numbers.forEach {
            require(it in 1..45) {
                throw IllegalArgumentException("[ERROR] $it must be between 1 and 45.") }
        }
    }

    fun validateBonusNumber(bonusNumber: Int?, lastWeekWinningNumbers: List<Int>) {
        require (bonusNumber != null) {
            throw IllegalArgumentException("[ERROR] Invalid bonus number input")
        }
        require(bonusNumber in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        require (bonusNumber !in lastWeekWinningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number can't be same as last week winning numbers.")
        }
    }

}