package lotto

object Validator {

    fun validatePurchaseAmount(input: String): Int {
        val number = input.toIntOrNull()
        if (number == null)
            throw IllegalArgumentException(Message.ERROR_INVALID_NUMBER)
        if (number < 0)
            throw IllegalArgumentException(Message.ERROR_NEGATIVE_NUMBER)
        if (number % LottoConstant.TICKET_PRICE !=  0)
            throw IllegalArgumentException(Message.ERROR_NOT_THOUSANDS)
        return number
    }
}