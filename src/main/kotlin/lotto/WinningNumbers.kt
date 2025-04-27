package lotto

class WinningNumbers(val mainNumbers: List<Int?>, val bonusNumber: Int?) {

    companion object {
        const val MIN_VALUE_LOTTO = 1
        const val MAX_VALUE_LOTTO = 45
    }

    init {
        require((mainNumbers.size == 6) && (mainNumbers.toSet().size ==6)) {
            "[ERROR] Main numbers must contain exactly 6 unique numbers"
        }
        require(mainNumbers.all { it in MIN_VALUE_LOTTO .. MAX_VALUE_LOTTO }) {
            "[ERROR] Numbers must be in the range [$MIN_VALUE_LOTTO, $MAX_VALUE_LOTTO]"
        }
        require(bonusNumber in MIN_VALUE_LOTTO .. MAX_VALUE_LOTTO)
        require(!mainNumbers.contains(bonusNumber)) {
            "[ERROR] Bonus number is not contained in main numbers"
        }
    }
}