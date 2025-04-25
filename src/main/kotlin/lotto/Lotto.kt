package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun compareTicket(winningNumbers: List<Int>, bonusNumber: Int): LottoTicketCategory {
        val matchCount = numbers.count { it in winningNumbers }
        val hasBonus = bonusNumber in numbers

        // Print debug info to verify the match count and bonus number check

        return try {
            LottoTicketCategory.fromMatchCount(matchCount, hasBonus)
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
            throw e // rethrow exception after logging
        }
    }

}
