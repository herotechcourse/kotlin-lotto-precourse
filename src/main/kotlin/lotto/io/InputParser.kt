package lotto.io

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

object InputParser {

    fun parsePurchaseAmount(input: String): Int {
        validateNotBlank(input)

        val amount = requireNotNull(input.toIntOrNull()) { "[ERROR] Invalid Amount." }

        require(amount >= 1000) { "[ERROR] Amount must be at least 1000." }

        require(amount % 1000 == 0) {"[ERROR] Amount must be divisible by 1,000."}

        return amount / 1000
    }

    fun parseWinningNumbers(input: String): List<Int> {
        validateNotBlank(input)

        val stringNumbers = input.split(",")
        val winningNumbers = mutableListOf<Int>()

        require(stringNumbers.size == COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(stringNumbers.size == stringNumbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }

        return convertToIntList(stringNumbers, winningNumbers)
    }

    fun parseBonusNumber(input: String, numbers: List<Int>): Int {
        validateNotBlank(input)

        val bonusNumber = requireNotNull(input.toIntOrNull()) { "[ERROR] Invalid BonusNumber." }

        require(bonusNumber in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] BonusNumber must be between 1 and 45." }
        require(bonusNumber !in numbers) { "[ERROR] Bonus number must not be in the winning numbers." }

        return bonusNumber
    }

    private fun validateNotBlank(input: String) {
        require(input.isNotBlank()) { "[ERROR] Invalid input." }
    }

    private fun convertToIntList(stringNumbers: List<String>, winningNumbers: MutableList<Int>): List<Int> {
        for (str in stringNumbers) {
            val winningNumber = str.trim().toIntOrNull()
            requireNotNull(winningNumber) { "[ERROR] Invalid WinningNumber." }
            winningNumbers.add(winningNumber)
        }
        return winningNumbers
    }

}