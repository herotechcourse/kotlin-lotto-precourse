package lotto.domain

import lotto.Lotto

object InputValidator {
    fun validatePurchaseAmount(parsedAmount: Int) {
        require(parsedAmount > 0) { "[ERROR] Purchase Amount must be greater than 0." }
        require(parsedAmount % LottoConstants.Ticket.PRICE == 0) {
            "[ERROR] Purchase Amount must be a multiple of ${LottoConstants.Ticket.PRICE}."
        }
    }

    fun parseAndValidatePurchaseAmount(amount: String): Int {
        if (amount.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Purchase Amount cannot be empty.")
        }
        val parsedAmount =
                amount.toIntOrNull()
                        ?: throw IllegalArgumentException(
                                "[ERROR] Purchase Amount must be a number."
                        )

        validatePurchaseAmount(parsedAmount)

        return parsedAmount
    }

    fun parseAndValidateLottoNumbers(lottoNumbers: String): Lotto {
        if (lottoNumbers.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Lotto Numbers cannot be empty.")
        }
        val parsedLottoNumberList =
                lottoNumbers.split(",").map {
                    it.toIntOrNull()
                            ?: throw IllegalArgumentException(
                                    "[ERROR] Lotto Numbers must be numbers."
                            )
                }
        val winningLotto = Lotto(parsedLottoNumberList) // validation happens in Lotto constructor

        return winningLotto
    }

    fun validateBonusNumber(bonusNumber: Int, winningLotto: Lotto) {
        require(bonusNumber !in winningLotto.getNumbers) {
            "[ERROR] Bonus Number must not be in Winning Lotto Numbers."
        }
        require(bonusNumber in LottoConstants.NumberRange.MIN..LottoConstants.NumberRange.MAX) {
            "[ERROR] Bonus Number must be between ${LottoConstants.NumberRange.MIN} and ${LottoConstants.NumberRange.MAX}."
        }
    }

    fun parseAndValidateBonusNumber(bonusNumber: String, winningLotto: Lotto): Int {
        if (bonusNumber.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Bonus Number cannot be empty.")
        }
        val parsedBonusNumber =
                bonusNumber.toIntOrNull()
                        ?: throw IllegalArgumentException("[ERROR] Bonus Number must be a number.")

        validateBonusNumber(parsedBonusNumber, winningLotto)

        return parsedBonusNumber
    }
}
