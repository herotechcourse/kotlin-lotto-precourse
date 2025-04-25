package lotto.utils

import lotto.Lotto
import lotto.model.WinnerLotto

object InputValidator {

    fun validatePurchaseAmount(amount: String): Long {
        val purchaseAmount = InputParser.parsePurchaseAmount(amount)
        when {
            (purchaseAmount < 0) -> throw IllegalArgumentException("Purchase amount must be positive number")
            (purchaseAmount < Lotto.COST) -> throw IllegalArgumentException("Purchase amount must be bigger than 1 ticket cost (${Lotto.COST})")
        }
        return purchaseAmount
    }


    fun validateWinnerLottoAndGetLotto(numbers: String): Lotto {
        val lottoNumbers = InputParser.parseWinnerLottoNumbers(numbers)
        return Lotto(lottoNumbers)
    }


    fun validateBonusNumberAndGetWinnerLotto(number: String, winnerLotto: Lotto): WinnerLotto {
        val bonusNumber = InputParser.parseWinnerBonusNumber(number)
        return WinnerLotto(winnerLotto, bonusNumber)
    }
}