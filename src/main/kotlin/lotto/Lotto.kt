package lotto

import lotto.domain.CurrencyType
import lotto.domain.LottoNumber.Companion.MAX_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_NUMBER

class Lotto private constructor(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly unique 6 numbers." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER." }
    }

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    companion object {
        val CURRENCY: CurrencyType = CurrencyType.KRW
        const val PRICE: Int = 1_000
        const val NUMBER_COUNT: Int = 6

        fun from(numbers: List<Int>): Lotto {
            return Lotto(numbers)
        }
    }
}
