package lotto.domain

import lotto.Lotto

class WinningNumbers(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == SIZE) { "[ERROR] Winning numbers must contain exactly $SIZE numbers." }
        require(numbers.distinct().size == SIZE) { "[ERROR] Winning numbers must not contain duplicates." }
    }

    fun matchCount(lotto: Lotto): Int {
        return lotto.getSortedNumbers().count { lottoNumber ->
            numbers.any { it.number == lottoNumber }
        }
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    fun getNumbers(): List<LottoNumber> = numbers.toList()

    companion object {
        private const val SIZE = 6

        fun from(rawNumbers: List<Int>): WinningNumbers {
            val lottoNumbers = rawNumbers.map { LottoNumber(it) }
            return WinningNumbers(lottoNumbers)
        }
    }

    override fun toString(): String {
        return numbers.map { it.number }.sorted().toString()
    }
}