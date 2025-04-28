package lotto.util

object LottoValidator {
    fun validateAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a positive multiple of 1000.")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6 || numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers.")
        }

        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }

        if (bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
        }
    }
}
