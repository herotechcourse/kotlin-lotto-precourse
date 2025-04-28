package lotto

class Lotto(private val numbers: List<Int>) {

    // Define prizes for Lotto
    enum class Prize(val namePrize: String, val valuePrize: Int) {
        NOPRIZE ( "Less than 3 matches", 0),
        FIFTH ("3 Matches (5,000 KRW)", 5_000),
        FOURTH ("4 Matches (50,000 KRW)", 50_000),
        THIRD ("5 Matches (1,500,000 KRW)", 1_500_000),
        SECOND ("5 Matches + Bonus Ball (30,000,000 KRW)", 30_000_000),
        FIRST ("6 Matches (2,000,000,000 KRW)", 2_000_000_000)

    }

    // Condition for Lotto tickets
    init {

        require((numbers.size == SIZE_LOTTO) && (numbers.toSet().size == SIZE_LOTTO)) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in MIN_VALUE_LOTTO .. MAX_VALUE_LOTTO}) {
            "[ERROR] Lotto numbers must in the range [$MIN_VALUE_LOTTO,$MAX_VALUE_LOTTO]."
        }

    }

    // Get tickets in increasing order
    fun getTicket(): List<Int> = numbers.sorted()

    // Return prize corresponding to winning numbers
    fun checkPrize(winningNumbers: WinningNumbers): Prize {

        // Extract winningNumber and bonusNumber
        val winningNumber = winningNumbers.mainNumbers
        val bonusNumber = winningNumbers.bonusNumber

        // Calculate number of matches
        val matchedNumbers = numbers.count { it in winningNumber }
        val matchedBonusNumber = bonusNumber in numbers

        // Return Prize based on the conditions
        if (matchedNumbers == 6) return Prize.FIRST
        if (matchedNumbers == 5 && matchedBonusNumber) return Prize.SECOND
        if (matchedNumbers == 5) return Prize.THIRD
        if (matchedNumbers == 4) return Prize.FOURTH
        if (matchedNumbers == 3) return Prize.FIFTH

        return Prize.NOPRIZE
    }

    // Define constants for Lotto class
    companion object {
        const val MIN_VALUE_LOTTO = 1
        const val MAX_VALUE_LOTTO = 45
        const val SIZE_LOTTO = 6
        const val PRICE_TICKET = 1_000
    }

}
