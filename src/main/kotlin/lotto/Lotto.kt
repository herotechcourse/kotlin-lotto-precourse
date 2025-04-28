package lotto

import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_INVALID_LOTTO_LIMIT
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_LOTTO_LENGTH_IS_NOT_6
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_LOTTO_NUMBER_NOT_UNIQUE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ERROR_MESSAGE_LOTTO_LENGTH_IS_NOT_6 }
        require(numbers.distinct().size == 6) { ERROR_MESSAGE_LOTTO_NUMBER_NOT_UNIQUE }
        require(numbers.all { it in 1..45 }){ ERROR_MESSAGE_INVALID_LOTTO_LIMIT }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getLottoNumber(): List<Int> {
        return numbers
    }

    fun containsNumber(number: Int): Boolean{
        return numbers.contains(number)
    }

    fun countMatchingNumbers(anotherTicket : Lotto): Int {
        return numbers.count { it in anotherTicket.getLottoNumber() }
    }
}
