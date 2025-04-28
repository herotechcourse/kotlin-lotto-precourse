package input.validation

import lotto.config.INVALID_LOTTO_NUMBER_MSG
import lotto.config.MAX_LOTTO_NUMBER
import lotto.config.MIN_LOTTO_NUMBER

fun validateAndReturnLottoNumber(num: Int): Int{
    validateLottoNumber(num)
    return num
}
fun validateLottoNumber(num: Int) {
    if(num !in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        throw IllegalArgumentException(INVALID_LOTTO_NUMBER_MSG)
}