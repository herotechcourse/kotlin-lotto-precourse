package lotto

import lotto.domain.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_SIZE) { ErrorMessages.LOTTO_NUMBER_SIZE_ERROR }
        require(numbers.toSet().size == LottoConstants.LOTTO_NUMBER_SIZE) { ErrorMessages.LOTTO_DUPLICATED_NUMBER_ERROR }

        numbers.forEach {
            require(it in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER) {
                ErrorMessages.LOTTO_NUMBER_RANGE_ERROR
            }
        }
    }

    fun formatForDisplay(): String {
        return numbers.sorted().toString()
    }

    fun match(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoRank {
        val matchCount = numbers.count { it in winningNumbers.numbers }
        val matchBonus = bonusNumber.number in numbers

        return LottoRank.from(matchCount, matchBonus)
    }
}
