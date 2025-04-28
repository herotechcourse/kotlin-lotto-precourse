package lotto.domain

fun throwInvalidBudgetException(message: String): Nothing {
    throw IllegalArgumentException(message)
}
