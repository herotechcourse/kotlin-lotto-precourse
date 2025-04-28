import lotto.domain.throwInvalidBudgetException

class WinningNumberValidator {
    private val seenNumbers = mutableListOf<Int>()

    fun run(inputs: List<Int>): List<Int> {
        inputs.forEach { number ->
            checkRange(number)
            if (checkNoDuplicates(number)) seenNumbers.add(number)
        }
        return seenNumbers
    }

    fun checkNoDuplicates(number: Int): Boolean {
        if (seenNumbers.contains(number)) {
            throwInvalidBudgetException("[ERROR] Winning number $number is duplicated")
        }
        return true
    }

    fun checkRange(number: Int) {
        if (number !in 1..45) {
            throwInvalidBudgetException("[ERROR] Winning number $number must be between 1 and 45")
        }
    }

    fun getBonus(bonus: Int): Int {
        checkRange(bonus)
        checkNoDuplicates(bonus)
        return bonus
    }
}