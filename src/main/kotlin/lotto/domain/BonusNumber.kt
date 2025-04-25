package lotto.domain

class BonusNumber(private val bonus: Int, private val winningNumbers: List<Int>) {

    init {
        require(bonus in MIN_NUMBER..MAX_NUMBER) { "[ERROR] Bonus number must be between $MIN_NUMBER and $MAX_NUMBER." }
        require(bonus !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    fun get(): Int = bonus

    companion object{
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}