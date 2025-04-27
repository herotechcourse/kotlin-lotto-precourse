package lotto

object LotteryTicketMachine {

    private val tickets = mutableListOf<List<Int>>()

    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers must be provided.")
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        if (numbers.any { it !in 1..45}) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
        }
    }

    fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        }
    }
}