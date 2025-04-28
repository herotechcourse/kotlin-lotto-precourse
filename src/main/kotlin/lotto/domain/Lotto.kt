package lotto.domain

import lotto.constant.Constants

class Lotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == SIZE) { Constants.ERROR_WRONG_WINNING_NUMBER_COUNT }
        require(numbers.distinct().size == SIZE) { Constants.ERROR_DUPLICATE_WINNING_NUMBERS }
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.map { it.number }.sorted()
    }

    companion object {
        const val SIZE = 6

        fun of(rawNumbers: List<Int>): Lotto {
            val lottoNumbers = rawNumbers.map { LottoNumber(it) }
            return Lotto(lottoNumbers)
        }
    }

    override fun toString(): String {
        return getSortedNumbers().toString()
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

}