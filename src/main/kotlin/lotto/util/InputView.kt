package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

fun inputPurchasedAmount(): Int {
    printPurchasedAmountInputPhrase()
    val userInput = Console.readLine()
    validateNonNumeric(userInput)
    validateNumberRange(userInput)
    val amount = userInput.toInt()
    validateUnitOfAmount(amount)
    return amount
}

fun inputUserWinningNumbers(): Lotto {
    printWinningNumbersInputPhrase()
    val userInput = Console.readLine()
    validateNonNumericWithoutComma(userInput)
    val winningNumbers = userInput.split(",").map { it.trim().toInt() }
    return Lotto(winningNumbers)
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

fun validateNonNumericWithoutComma(userInput: String) {
    val regex = Regex("[0-9,]")
    val removeCharacters = regex.replace(userInput, "")
    if (removeCharacters.isNotEmpty()) {
        throw IllegalArgumentException("Non-numeric characters excluding commas are used")
    }
}