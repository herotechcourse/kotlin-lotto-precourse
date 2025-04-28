package lotto.domain

class LottoTicket (private val numbers: List<Int>) {
    init {
        require (numbers.size == LOTTO_NUMBERS_SIZE) { ERROR_INVALID_SIZE }
        require(numbers.toSet().size == 6) { ERROR_DUPLICATED }
    }
    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatching(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
        private const val ERROR_INVALID_SIZE = "[ERROR] A lotto ticket must have exactly 6 numbers."
        private const val ERROR_DUPLICATED = "[ERROR] Lotto numbers must not contain duplicates."
    }
}
