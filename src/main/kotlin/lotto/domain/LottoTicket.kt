package lotto.domain

class LottoTicket (private val numbers: List<Int>) {
    init {
        require (numbers.size == 6) { "[ERROR] A lotto ticket must have exactly 6 numbers." }
    }
    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatching(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
