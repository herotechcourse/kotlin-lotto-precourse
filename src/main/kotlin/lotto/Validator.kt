package lotto


object LotteryValidator {
    fun validateAmount(amount: Int) {
        require(amount > 0) { "Amount must be positive" }
        require(amount % Lotto.TICKET_PRICE == 0) {
            "Amount must be multiples of ${Lotto.TICKET_PRICE}"
        }
    }

    fun validateWinningNumbers(numbers: Set<Int>) {
        require(numbers.size == 6) { "Need exactly 6 winning numbers" }
        require(numbers.all { it in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER }) {
            "Lotto numbers must be between 1 and 45."
        }
    }

    fun validateBonusNumber(bonus: Int, winningNumbers: Set<Int>) {
        require(bonus in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER) {
            "Bonus number is out of range"
        }
        require(bonus !in winningNumbers) {
            "Bonus number must be different from winning numbers"
        }
    }
}
