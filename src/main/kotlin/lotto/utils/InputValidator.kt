package lotto.utils

import lotto.Lotto
import lotto.model.WinnerLotto

class InputValidator {

    fun validatePurchaseAmount(amount: String): Long {
        val purchaseAmount =
            amount.toLongOrNull() ?: throw IllegalArgumentException("Purchase amount must be numeric number")
        when {
            purchaseAmount < 0 -> throw IllegalArgumentException("Purchase amount must be positive number")
            purchaseAmount < Lotto.COST -> throw IllegalArgumentException("Purchase amount must be bigger than 1 ticket cost(${Lotto.COST})")
        }
        return purchaseAmount
    }

    fun validateWinnerLotto(numbers: String): Lotto {
        val lottoNumbers = try {
            numbers.split(",").map { it.trim().toInt() }
        } catch (e: Exception) {
            throw IllegalArgumentException("Winner Lotto Numbers must be numeric number")
        }

        return try {
            Lotto(lottoNumbers)
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }

    }

    fun validateBonusNumber(number: String, winnerLotto: Lotto): WinnerLotto {
        val bonusNumber = number.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be numeric number")
        return try {
            WinnerLotto(winnerLotto, bonusNumber)
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }
    }
}