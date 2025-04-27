package lotto.InputValidation

class `AmountValidation` {
    //Check if the purchase amount is null
    fun NullCheckNumber(amount: String): Int {
        if (amount.isEmpty() || amount.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] Input needs to be an integer")
        return amount.toInt()
    }

    //Check if purchase amount is positive
    fun ValidateAmountPositive(amount: Int) {
        if (amount <= 0) throw IllegalArgumentException("[ERROR] Amount entered must be a valid number greater than 0")
    }

    //Check if purchase amount is a multiple of 1000
    fun ValidateAmountMultipleOfThousand(amount: Int) {
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount entered must be multiple of 1000")
    }
}