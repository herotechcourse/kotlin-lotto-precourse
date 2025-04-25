package lotto.domain

import lotto.messages.PurchaseErrorMessage

class InputValidator {

    fun validatePurchaseInput(input: String): Int {

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(PurchaseErrorMessage.NOT_A_NUMBER.message)
        if (amount < 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NEGATIVE_NUMBER.message)
        }
        if (amount < 1000) {
            throw IllegalArgumentException(PurchaseErrorMessage.LESS_THAN_MINIMUM.message)
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NOT_A_MULTIPLE_OF_1000.message)
        }

        return amount
    }
}