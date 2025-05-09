package lotto.controller

sealed class ValidatedResult<out T> {
    data class Success<T>(val value: T) : ValidatedResult<T>()
    data class Failure(val reasons: List<String>) : ValidatedResult<Nothing>()
}
