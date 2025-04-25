package lotto.utils

import lotto.Lotto

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
        val winnerLotto: Lotto

        if (lottoNumbers.toSet().size != lottoNumbers.size) throw IllegalArgumentException("Winner Lotto numbers must be unique numbers")

        return try {
            Lotto(lottoNumbers)
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }

    }

    fun validateBonusNumber(number: String, winnerLotto: Lotto): Int {
        val bonusNumber = number.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be numeric number")

        if (bonusNumber in winnerLotto.numbers) throw IllegalArgumentException("Bonus Number must be a unique number")

        return bonusNumber
    }
}