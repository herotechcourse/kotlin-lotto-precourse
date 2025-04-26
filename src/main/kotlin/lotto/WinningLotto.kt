package lotto

class WinningLotto (
    private val winningNumbers: List<Int?>,
    private val bonusNumber: Int?) {

    init {
        require(winningNumbers.none { it == null }) { LottoErrorEnum.NULL_WINNING_NUMBER.message }
        require(bonusNumber != null) { LottoErrorEnum.NULL_BONUS_NUMBER.message }
        require(winningNumbers.size == 6) { LottoErrorEnum.INVALID_SIZE.message }
        require(winningNumbers.all { it in 1..45 }) { LottoErrorEnum.NUMBER_OUT_OF_RANGE.message }
        require(winningNumbers.size == winningNumbers.distinct().size) { LottoErrorEnum.DUPLICATED_NUMBER.message }
        require(bonusNumber in (1..45)) { LottoErrorEnum.NUMBER_OUT_OF_RANGE.message }
        require(winningNumbers.none { it == bonusNumber }) { LottoErrorEnum.DUPLICATED_NUMBER.message }
    }

    fun match (purchaseLotto: Lotto) : Int {
        val numbers : List<Int> = purchaseLotto.getNumbers()
        return winningNumbers.intersect(numbers.toSet()).size
    }

    fun matchBonus (purchaseLotto: Lotto) : Boolean {
        return bonusNumber in purchaseLotto.getNumbers()
    }
}