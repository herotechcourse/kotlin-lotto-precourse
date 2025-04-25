package lotto.util

object InputValidator {
    fun validateAndParseAmount(amountString: String): Int {
        require(!amountString.isNullOrBlank()) { "[ERROR]: Purchase amount cannot be empty." }

        val amount = parseInt(amountString)

        validatePositive(amount, "[ERROR]: Purchase amount must be positive.")
        validateMultipleOf1000(amount)
        return amount
    }

    fun validateAndParseWinningNums(numbersString: String?) :List<Int> {
        require(!numbersString.isNullOrBlank()) { "[ERROR]: Winning numbers input cannot be empty." }

        val numbersStrings = numbersString.split(",").map { it.trim() }
        val numbers = parseIntList(numbersStrings)

        validateWinningNumbersCnt(numbers)
        validateUniqueNumbers(numbers)
        validateNumbersInRange(numbers, 1, 45)

        return numbers
    }

    fun validateAndParseBonusNum(numberString: String?): Int {
        require(!numberString.isNullOrBlank()) { "[ERROR]: Bonus number cannot be empty." }
        val bonus = parseInt(numberString)

        validateNumberInRange(bonus, 1, 45)
        return bonus
    }

    private fun parseInt(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR]: Invalid number format.")
        }
    }

    private fun parseIntList(inputs: List<String>): List<Int> {
        try {
            if (inputs.any { it.isEmpty() }) {
                throw IllegalArgumentException("[ERROR]: Invalid number format or empty number in list.")
            }
            return inputs.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR]: Invalid number format.")
        }
    }

    private fun validatePositive(number: Int, errorMessage: String) {
        require(number > 0) { errorMessage }
    }

    private fun validateMultipleOf1000(number: Int) {
        require(number % 1000 == 0) { "[ERROR]: Purchase amount must be a multiple of 1000." }
    }

    private fun validateWinningNumbersCnt(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR]: Winning numbers must be exactly 6 numbers." }
    }

    private fun validateUniqueNumbers(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { "[ERROR]: numbers must be unique" }
    }

    private fun validateNumbersInRange(numbers: List<Int>, min: Int, max: Int) {
        require(numbers.all { it >= min && it <= max}) { "[ERROR]: Invalid number in range [$min, $max]." }
    }

    private fun validateNumberInRange(number: Int, min: Int, max: Int) {
        require(number >= min && number <= max) { "[ERROR]: Invalid number in range [$min, $max]." }
    }
}