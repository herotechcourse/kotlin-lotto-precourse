package lotto

import lotto.validation.LottoValidator

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    init {
        LottoValidator.validateLottoNumbers(winningNumbers)
        LottoValidator.validateNumberRange(bonusNumber)
        LottoValidator.validateBonusNumberDuplication(bonusNumber, winningNumbers)
    }

    /** Matches a given Lotto ticket against the winning numbers and bonus number to determine the rank. */
    fun match(lotto: Lotto): LottoRank {
        val matchCount = lotto.countMatchingNumbers(winningNumbers)
        val bonusMatch = lotto.contains(bonusNumber)
        return LottoRank.valueOf(matchCount, bonusMatch)
    }
} 