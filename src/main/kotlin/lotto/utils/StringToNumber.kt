package lotto.utils

import lotto.domain.throwInvalidBudgetException

fun StringToNumber(input: String): Int {
    val value = input.toIntOrNull()

    if (value == null) {
        throwInvalidBudgetException("[ERROR] Budget value must be a number")
    }

    return value
}

fun StringToList(input: String): List<Int?> {
    return input.split(",").map { it.toIntOrNull() }
}