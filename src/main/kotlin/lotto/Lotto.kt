package lotto

import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_RANGE_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_SIZE_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_UNIQUE_ERROR


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { NUMBERS_SIZE_ERROR }
        require(numbers.distinct().size == 6) { NUMBERS_UNIQUE_ERROR }
        require(numbers.all { it in 1..45 }) { NUMBERS_RANGE_ERROR }
    }

    fun getNumbers(): List<Int> = numbers

    fun countMatching(winningNumbers: List<Int>): Int =
        numbers.count { it in winningNumbers }

    fun hasBonus(bonusNumber: Int): Boolean =
        numbers.contains(bonusNumber)

    override fun toString(): String = numbers.toString()
}