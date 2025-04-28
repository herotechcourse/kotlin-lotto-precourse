package lotto.domain
import lotto.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers." }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto numbers must be unique." }
    }

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

}
