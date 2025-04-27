package lotto.util

import camp.nextstep.edu.missionutils.Console

fun inputPurchasedAmount() {
    printPurchasedAmountInputPhrase()
    val userInput = Console.readLine()
    validateNonNumeric(userInput)
    validateNumberRange(userInput)
    val amount = userInput.toInt()
    validateUnitOfAmount(amount)
}

fun validateNonNumeric(userInput: String) {
    val regex = Regex("[0-9]")
    val removeCharacters =regex.replace(userInput, "")
    if (removeCharacters.isNotEmpty()) {
        throw IllegalArgumentException("[ERROR] Numeric characters must be used")
    }
}

fun validateUnitOfAmount(amount: Int) {
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] The amount is not a unit of 1,000 KRW")
    }
}

fun validateNumberRange(userInput: String) {
    if (userInput.toIntOrNull() == null) {
        throw IllegalArgumentException("[ERROR] The amount exceeds the range of an Integer")
    }
}