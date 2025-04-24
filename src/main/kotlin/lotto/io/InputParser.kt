package lotto.io

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

object InputParser {

    fun parsePurchaseAmount(input: String): Int {
        require(input.isNotBlank()) { "[ERROR] Invalid input." }

        val amount = requireNotNull(input.toIntOrNull()) { "[ERROR] Invalid Amount." }

        require(amount >= 1000) { "[ERROR] Amount must be at least 1000." }

        require(amount % 1000 == 0) {"[ERROR] Amount must be divisible by 1,000."}

        return amount / 1000
    }

    fun parseWinningNumbers(input: String): List<Int> {
        require(input.isNotBlank()) { "[ERROR] Invalid input." }

        val stringNumbers = input.split(",")
        val winningNumbers = mutableListOf<Int>()

        require(stringNumbers.size == COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(stringNumbers.size == stringNumbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }

        for (str in stringNumbers) {
            val trimmed = str.trim()
            val winningNumber = trimmed.toIntOrNull()
            requireNotNull(winningNumber) { "[ERROR] Invalid WinningNumber." }
            winningNumbers.add(winningNumber)
        }

        return winningNumbers
    }

}