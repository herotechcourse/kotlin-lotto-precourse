package lotto

import lotto.business.LottoErrorMessage

class WinningNumber(private val numbers: List<Int>) {
    init {
        require(numbers.size == Lotto.LOTTO_SIZE) { LottoErrorMessage.INVALID_WINNING_NUMBER_SIZE.message }
        require(numbers.distinct().size == numbers.size) { LottoErrorMessage.WINNING_NUMBER_DUPLICATED.message }
        require(numbers.all { it in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER }) { LottoErrorMessage.INVALID_WINNING_NUMBER_RANGE.message }
    }

    companion object {
        fun from(numbers: String): WinningNumber {
            val numberList = numbers.split(",").map { number ->
                require(number.toIntOrNull() != null) { LottoErrorMessage.WINNING_NUMBER_NOT_INTEGER.message }
                number.toInt()
            }
            return WinningNumber(numberList)
        }
    }
}