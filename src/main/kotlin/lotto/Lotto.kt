package lotto

class Lotto(private val numbers: List<Int>) {

    companion object {
        const val MIN_VALUE_LOTTO = 1
        const val MAX_VALUE_LOTTO = 45
    }

    enum class Prize(val namePrize: String, val valuePrize: Int) {
        NOPRIZE ( "Less than 3 matches", 0),
        FIFTH ("3 Matches (5,000 KRW)", 5000),
        FOURTH ("4 Matches (50,000 KRW)", 50000),
        THIRD ("5 Matches (1,500,000 KRW)", 1500000),
        SECOND ("5 Matches + Bonus Ball (30,000,000 KRW)", 30000000),
        FIRST ("6 Matches (2,000,000,000 KRW)", 2000000000)

    }

    init {
        require((numbers.size == 6) && (numbers.toSet().size == 6)) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in MIN_VALUE_LOTTO .. MAX_VALUE_LOTTO}) {
            "[ERROR] Lotto numbers must in the range [$MIN_VALUE_LOTTO,$MAX_VALUE_LOTTO]."
        }

    }

    fun getTicket(): List<Int> = numbers.sorted()

    fun checkPrize(winningNumbers: WinningNumbers): Prize {
        val winningNumber = winningNumbers.mainNumbers
        val bonusNumber = winningNumbers.bonusNumber

        val matchedNumbers = numbers.count { it in winningNumber }
        val matchedBonusNumber = bonusNumber in numbers

        if (matchedNumbers == 6) return Prize.FIRST
        if (matchedNumbers == 5 && matchedBonusNumber) return Prize.SECOND
        if (matchedNumbers == 5) return Prize.THIRD
        if (matchedNumbers == 4) return Prize.FOURTH
        if (matchedNumbers == 3) return Prize.FIFTH

        return Prize.NOPRIZE
    }

    // TODO: Implement additional functions
}
