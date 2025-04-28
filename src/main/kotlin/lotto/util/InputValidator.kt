package lotto.view


import lotto.config.LottoConstants.LOTTO_NUMBER_ENDS
import lotto.config.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.config.LottoConstants.LOTTO_NUMBER_STARTS
import lotto.config.LottoConstants.LOTTO_PRICE
import lotto.config.Messages

object InputValidator {

    fun validateAmount(amount: Int) {
        checkDivisibility(amount)
        checkPositive(amount)
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        checkDuplicates(numbers)
        checkRange(numbers)
        checkSize(numbers)
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        checkRange(bonusNumber)
        checkDuplicates(bonusNumber, winningNumbers)
    }

    private fun checkDuplicates(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { Messages.WINNING_NUMBER_DUPLICATE }
    }

    private fun checkDuplicates(bonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber)) { Messages.BONUS_NUMBER_DUPLICATE }
    }

    private fun checkRange(numbers: List<Int>) {
        require(numbers.all { it in LOTTO_NUMBER_STARTS..LOTTO_NUMBER_ENDS }) { Messages.WINNING_NUMBER_OVER_RANGE }
    }

    private fun checkRange(number: Int) {
        require(number in LOTTO_NUMBER_STARTS..LOTTO_NUMBER_ENDS) { Messages.WINNING_NUMBER_OVER_RANGE }
    }

    private fun checkSize(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { Messages.WINNING_NUMBER_SIZE_NOT_SIX }
    }

    private fun checkDivisibility(purchaseAmount: Int) {
        require(purchaseAmount % LOTTO_PRICE == 0) { Messages.INPUT_NOT_DIVIDABLE }
    }

    private fun checkPositive(purchaseAmount: Int) {
        require(purchaseAmount > 0) { Messages.NUMBER_NOT_POSITIVE }
    }
}
