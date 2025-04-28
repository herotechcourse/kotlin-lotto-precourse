package lotto

class BonusNumber(private val bonusNumber: Int, lotto: Lotto) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus Number should be a between 1 and 45" }
        require(bonusNumber !in lotto.getLottoNumber()) { "[ERROR] Bonus Number should not be in Lotto numbers" }
    }

    fun getBonusNumber():Int{
        return bonusNumber
    }
}