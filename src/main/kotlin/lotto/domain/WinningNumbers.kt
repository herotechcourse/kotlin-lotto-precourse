package lotto.domain

class WinningNumbers private constructor(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { "[ERR] Winning numbers must be 6 numbers." }
    }

    fun toList(): List<Int> {
        return numbers.map { it.value }
    }

    fun contains(value: Int): Boolean {
        return numbers.contains(LottoNumber(value))
    }

    fun contains(value: LottoNumber): Boolean {
        return numbers.contains(value)
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(
                numbers.map { LottoNumber(it) }.toSet()
            )
        }
    }
}
