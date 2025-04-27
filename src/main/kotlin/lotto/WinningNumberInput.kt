package lotto

class WinningNumberInput(private val inputView: LottoInputView) {

    fun getWinningNumbers(): List<Int> {
        val input = inputView.getWinningNumbersInput()
        val numbers = parseNumbers(input)
        validateWinningNumbers(numbers)
        return numbers
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        val input = inputView.getBonusNumberInput()
        val bonusNumber =
            parseNumber(input) ?: throw IllegalArgumentException("Invalid input. Please enter a valid number.")
        validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun parseNumbers(input: String): List<Int> = input.split(",").mapNotNull { it.trim().toIntOrNull() }

    private fun parseNumber(input: String): Int? = input.trim().toIntOrNull()

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("You must enter exactly 6 numbers.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("Numbers must be unique.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("All numbers must be between 1 and 45.")
        }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("Bonus number must not be included in the winning numbers.")
        }
    }
}