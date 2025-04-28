package lotto.model

import lotto.common.ErrorMessages
import lotto.common.LottoUtil

class Winner(private val numbers: List<Int>, private val bonus: Int) {
    init {
        require(numbers.isNotEmpty()) { ErrorMessages.INVALID_WINNING_NUMBERS_TYPE }
        require(LottoUtil.isValidLottoSize(numbers)) { ErrorMessages.INVALID_WINNING_NUMBERS_SIZE }
        require(numbers.all { LottoUtil.isValidLottoNumber(it) }) { ErrorMessages.INVALID_WINNING_NUMBERS_UNIT }
        require(numbers.size == numbers.toSet().size) { ErrorMessages.INVALID_WINNING_NUMBERS_ITEM }
        require(LottoUtil.isValidLottoNumber(bonus)) { ErrorMessages.INVALID_BONUS_NUMBER_UNIT }
        require(!numbers.contains(bonus)) { ErrorMessages.INVALID_BONUS_NUMBER_ITEM }
    }

    fun getNumbers(): List<Int> = numbers.filterNotNull()

    fun getBonus(): Int = bonus
}
