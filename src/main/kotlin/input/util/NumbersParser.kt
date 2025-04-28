package input.util

import input.validation.validateAndReturnLottoNumber


private const val SEPARATOR = ",";
fun getNumbersFromInput(input: String): Array<Int> {
    return input.split(SEPARATOR).map{
        validateAndReturnLottoNumber(it.toInt())
    }.toTypedArray();
}