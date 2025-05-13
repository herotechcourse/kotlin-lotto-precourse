/**
 * validators
 */

package lotto

import extensions.firstDuplicatesIndices

class InputValidator {
    companion object {
        fun validatePurchaseAmount(amount: Int) {
            require((amount >= const.MIN_AMOUNT) && (amount <= const.MAX_AMOUNT)) {
                "${const.ERROR_MESSAGE_PREFIX}Amount: $amount - Must be in range ${const.MIN_AMOUNT} <= amount <= ${const.MAX_AMOUNT}"
            }

            require(amount % const.TICKET_PRICE == 0) {
                "${const.ERROR_MESSAGE_PREFIX}Amount: $amount - Must be a multiple of ${const.TICKET_PRICE}"
            }
        }

        fun validateWinningNumbers(numbers: List<Int>) {
            require(numbers.size == const.NUMBER_OF_LOTTO_NUMBERS) {
                "${const.ERROR_MESSAGE_PREFIX}${const.NUMBER_OF_LOTTO_NUMBERS} numbers are required, ${numbers.size} numbers were given."
            }

            numbers.mapIndexed { index, element ->
                require((element >= const.MIN_LOTTO_NUMBER) && (element <= const.MAX_LOTTO_NUMBER)) {
                    "${const.ERROR_MESSAGE_PREFIX}[$index] $element - Must be ${const.MIN_LOTTO_NUMBER} <= number <= ${const.MAX_LOTTO_NUMBER}"
                }
            }

            val indices = numbers.firstDuplicatesIndices()
            require(indices.first == indices.second) {
                "${const.ERROR_MESSAGE_PREFIX}[${indices.first}, ${indices.second}] Duplicate numbers are not accepted: ${numbers[indices.first]}"
            }
        }

        fun validateBonusNumbers(numbers: List<Int>, winningNumbers: List<Int>) {
            require(numbers.size == const.NUMBER_OF_BONUS_NUMBERS) {
                "${const.ERROR_MESSAGE_PREFIX}${const.NUMBER_OF_LOTTO_NUMBERS} numbers are required, ${numbers.size} numbers were given."
            }

            numbers.mapIndexed { index, element ->
                require((element >= const.MIN_LOTTO_NUMBER) && (element <= const.MAX_LOTTO_NUMBER)) {
                    "${const.ERROR_MESSAGE_PREFIX}[$index] $element - Must be ${const.MIN_LOTTO_NUMBER} <= number <= ${const.MAX_LOTTO_NUMBER}"
                }
            }

            numbers.mapIndexed { index, element ->
                require(winningNumbers.indexOf(element) == -1) {
                    "${const.ERROR_MESSAGE_PREFIX}[$index] $element - Already included in winning numbers: $winningNumbers"
                }
            }

            val indices = numbers.firstDuplicatesIndices()
            require(indices.first == indices.second) {
                "${const.ERROR_MESSAGE_PREFIX}[${indices.first}, ${indices.second}] Duplicate numbers are not accepted: ${numbers[indices.first]}"
            }
        }
    }
}