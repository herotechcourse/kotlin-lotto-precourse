package lotto.util

import lotto.util.Constants.LOTTERY_NUMBER_COUNT
import lotto.util.Constants.MAX_LOTTERY_NUM
import lotto.util.Constants.MIN_LOTTERY_NUM
import lotto.util.Constants.PRICE_PER_LOTTO

object Validation {

    private const val ERROR_PREFIX = "[ERROR]"

    fun validateLottoNumbers(numbers: List<Int>) {
        require(numbers.size == LOTTERY_NUMBER_COUNT) {
            "$ERROR_PREFIX Lotto numbers must contain ${LOTTERY_NUMBER_COUNT} numbers."
        }
        require(numbers.toSet().size == LOTTERY_NUMBER_COUNT) {
            "$ERROR_PREFIX Lotto numbers cannot contain duplicate numbers."
        }
        numbers.forEach {validateNumberInRange(it)}
    }

    fun validateLottoAmount(amount: Int) {
        require(amount > 0) {"$ERROR_PREFIX Purchase amount must be a positive number."}
        require(amount % PRICE_PER_LOTTO == 0) {
            "$ERROR_PREFIX Purchase amount must be in units of ${PRICE_PER_LOTTO}."
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == LOTTERY_NUMBER_COUNT) {
            "$ERROR_PREFIX Winning numbers must contain ${LOTTERY_NUMBER_COUNT} numbers."
        }
        require(numbers.toSet().size == LOTTERY_NUMBER_COUNT) {
            "$ERROR_PREFIX Winning numbers cannot contain duplicate numbers."
        }
        numbers.forEach {validateNumberInRange(it)}
    }

    fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        validateNumberInRange(bonus)
        require(!winningNumbers.contains(bonus)) {
            "$ERROR_PREFIX Bonus number cannot be the same as any winning number."
        }
    }

    private fun validateNumberInRange(number: Int) {
        require(number in MIN_LOTTERY_NUM..MAX_LOTTERY_NUM) {
            "$ERROR_PREFIX Lotto numbers must be between ${MIN_LOTTERY_NUM} and ${MAX_LOTTERY_NUM}."
        }
    }
}