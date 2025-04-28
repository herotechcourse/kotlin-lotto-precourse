package lotto.domain

class WinningNumbers private constructor(
    val numbers: List<LottoNumber>,
    val bonusNumber: LottoNumber
) {
    init {
        require(numbers.size == NUMBERS_COUNT) { "[ERROR] Winning numbers must contain exactly $NUMBERS_COUNT numbers." }
        require(numbers.distinct().size == NUMBERS_COUNT) { "[ERROR] Winning numbers must be unique." }
        require(bonusNumber !in numbers) { "[ERROR] Bonus number must not be in winning numbers." }
    }

    companion object {
        private const val NUMBERS_COUNT = 6

        fun from(numbers: List<Int>, bonusNumber: Int): WinningNumbers {
            val lottoNumbers = numbers.map { LottoNumber.from(it) }.sortedBy { it.value }
            val bonusLottoNumber = LottoNumber.from(bonusNumber)
            return WinningNumbers(lottoNumbers, bonusLottoNumber)
        }
    }
} 