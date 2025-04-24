package lotto

class InputValidator {
    fun validateBudget(input: String) {
        require(!input.isBlank()) { "[ERROR] Input cannot be blank." }
        require(input > "1") { "[ERROR] Input cannot be smaller than 1" }
        require(input.toInt() % 1000 == 0) { "[ERROR] Input cannot be smaller than 1" }
    }

    fun validateWinningNumbers(input: String) {
        val separatedInputs = input.split(",").map { it.trim() }
        require(!input.isBlank()) { "[ERROR] Input cannot be blank." }
        require(separatedInputs.size == 6) { "[ERROR] Expecting 6 winning numbers coma separated" }
        separatedInputs.forEach { numberString ->
            val number = numberString.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Number must be numeric")
            require(number in 1..45) {
                "[ERROR] Invalid winning number: $numberString. Numbers should be between 1 and 45"
            }
        }
        require(separatedInputs.distinct().size == 6) { "[ERROR] Input cannot contain duplicate numbers" }
    }
}