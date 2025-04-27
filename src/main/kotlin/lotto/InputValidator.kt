package lotto

object InputValidator {
    fun validateMoneyAmount(amount: String?): Int {
        val amountMoney = amount?.toIntOrNull()
        if ((amountMoney == null) || ((amountMoney % 1000) != 0)) {
            throw IllegalArgumentException("[ERROR] The amount must be integer and divisible by 1,000")
        }
        return amountMoney/1000
    }

}