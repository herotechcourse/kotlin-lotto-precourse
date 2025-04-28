package lotto

import lotto.domain.LottoNumber

class Lotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == SIZE) { "[ERROR] Lotto must contain exactly $SIZE numbers." }
        require(numbers.distinct().size == SIZE) { "[ERROR] Lotto numbers must not contain duplicates." }
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