import lotto.domain.throwInvalidBudgetException

class WinningNumberValidator {
    private val seenNumbers = mutableSetOf<Int>()

    fun run(inputs: List<Int>): Set<Int> {
        inputs.forEach { number ->
            checkRange(number)
            checkNoDuplicates(number)
        }

        return seenNumbers
    }

    fun checkNoDuplicates(number: Int) {
        if (!seenNumbers.add(number)) {
            throwInvalidBudgetException("[ERROR] Winning number $number is duplicated")
        }
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