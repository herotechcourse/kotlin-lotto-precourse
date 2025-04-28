package lotto.domain

class WinningNumbers private constructor(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { "[ERR] Winning numbers must be 6 numbers." }
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(
                numbers.map { LottoNumber(it) }.toSet()
            )
        }
    }
}
