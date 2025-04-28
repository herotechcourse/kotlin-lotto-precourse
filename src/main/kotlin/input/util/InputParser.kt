package input.util

import input.validation.validateAndReturnLottoNumber
import input.validation.validateAndReturnTicketAmount


private const val SEPARATOR = ",";
fun getValidatedLottoNumbers(input: String): Array<Int> {
    return input.split(SEPARATOR).map{
        validateAndReturnLottoNumber(it.toInt())
    }.toTypedArray();
}

fun getValidatedTicketAmount(input: String): Int {
    return validateAndReturnTicketAmount(input.toInt())
}