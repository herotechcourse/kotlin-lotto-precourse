package lotto

class WinningNumbers(val mainNumbers: List<Int?>, val bonusNumber: Int?) {

    init {
        require((mainNumbers.size == Lotto.SIZE_LOTTO) && (mainNumbers.toSet().size == Lotto.SIZE_LOTTO)) {
            "[ERROR] Main numbers must contain exactly ${Lotto.SIZE_LOTTO} unique numbers"
        }
        require(mainNumbers.all { it in Lotto.MIN_VALUE_LOTTO .. Lotto.MAX_VALUE_LOTTO }) {
            "[ERROR] Numbers must be in the range [${Lotto.MIN_VALUE_LOTTO}, ${Lotto.MAX_VALUE_LOTTO}]"
        }
        require(bonusNumber in Lotto.MIN_VALUE_LOTTO .. Lotto.MAX_VALUE_LOTTO)
        require(!mainNumbers.contains(bonusNumber)) {
            "[ERROR] Bonus number is not contained in main numbers"
        }
    }
}