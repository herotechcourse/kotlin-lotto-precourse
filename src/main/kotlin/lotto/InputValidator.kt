package lotto

class InputValidator {
    fun validateBudget(input: String) {
        require(!input.isBlank()) { LottoMessages.blankInput }
        require(input > "1") { LottoMessages.smallThanOne }
        require(input.toInt() % 1000 == 0) { LottoMessages.divisibleByThousand }
    }

    fun validateWinningNumbers(input: String) {
        val separatedInputs = input.split(",").map { it.trim() }
        require(!input.isBlank()) { LottoMessages.blankInput }
        require(separatedInputs.size == 6) { LottoMessages.invalidWinningNumbers }
        separatedInputs.forEach { numberString ->
            val number = numberString.toIntOrNull()
                ?: throw IllegalArgumentException( LottoMessages.invalidWinningNumbers)
            require(number in 1..45) { LottoMessages.rangeOneToFortyfive}
        }
        require(separatedInputs.distinct().size == 6) { LottoMessages.duplicate }
    }

    fun validateBonusInput(input: String) {
        require(input.isNotBlank()) { LottoMessages.blankInput }
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a numeric value.")
        require(number in 1..45) { LottoMessages.rangeOneToFortyfive}
    }
}