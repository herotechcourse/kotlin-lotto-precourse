package lotto
class LottoValidator {
    fun validatePurchaseAmount(amount: Long): Long {
        require(amount >= TICKET_PRICE) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(amount % TICKET_PRICE == 0L) {"[ERROR] Purchase amount must be divisible by 1,000."}
        return amount
    }

    fun validateWinningNumbers(numbers: List<Int>): List<Int> {
        require(numbers.size == LOTTO_NUMBER_SIZE) {"[ERROR] Winning numbers must be exactly 6 numbers."}
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {"[ERROR] Winning numbers must be between 1 and 45."}
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) {"[ERROR] Winning numbers must be unique."}
        return numbers
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>): Int {
        require(bonusNumber in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {"[ERROR] Bonus number must be between 1 and 45."}
        require(bonusNumber !in winningNumbers) {"[ERROR] Bonus number must not be in winning numbers." }
        return bonusNumber
    }
}
