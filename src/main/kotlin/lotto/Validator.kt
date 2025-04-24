package lotto

object Validator {

    fun validatePurchaseAmount(input: String): Int {
        val number = input.toIntOrNull()
        if (number == null)
            throw IllegalArgumentException(Messages.ERROR_INVALID_NUMBER)
        if (number < 0)
            throw IllegalArgumentException(Messages.ERROR_NEGATIVE_NUMBER)
        if (number % LottoConstants.TICKET_PRICE !=  0)
            throw IllegalArgumentException(Messages.ERROR_NOT_THOUSANDS)
        return number
    }
}