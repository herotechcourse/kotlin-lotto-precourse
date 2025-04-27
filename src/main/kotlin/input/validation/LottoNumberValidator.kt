package input.validation

internal const val INVALID_LOTTO_NUMBER_MSG = "Numbers must be in the range from 1 to 45."

internal const val MIN_LOTTO_NUMBER = 1
internal const val MAX_LOTTO_NUMBER = 45

fun validateAndReturnLottoNumber(num: Int): Int{
    validateLottoNumber(num)
    return num
}
fun validateLottoNumber(num: Int) {
    if(num !in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        throw IllegalArgumentException(INVALID_LOTTO_NUMBER_MSG)
}