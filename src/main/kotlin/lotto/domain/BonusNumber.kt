package lotto.domain

class BonusNumber(
    private val bonusNumber: Int,
    private val winningNumbers: List<Int>) {

    init {
        validateBonusNumberInRange()
        validateBonusNumberNotDuplicated()
    }

    private fun validateBonusNumberInRange() {
        require(bonusNumber in LOTTO_NUMBER_RANGE) { ERROR_OUT_OF_RANGE }
    }

    private fun validateBonusNumberNotDuplicated() {
        require(!winningNumbers.contains(bonusNumber)) { ERROR_DUPLICATED_NUMBER }
    }

    fun value(): Int = bonusNumber

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        private const val ERROR_OUT_OF_RANGE = "[ERROR] Bonus number must be between 1 and 45."
        private const val ERROR_DUPLICATED_NUMBER = "[ERROR] Bonus number must not duplicate a winning number."
    }
}
