package lotto

class WinningLotto (
    private val winningNumbers: List<Int?>,
    private val bonusNumber: Int?) {

    init {
        require(winningNumbers.none { it == null }) { "[ERROR]  Lotto numbers must be integer." }
        require(bonusNumber != null) { "[ERROR]  Lotto number must be integer." }
        require(winningNumbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(winningNumbers.size == winningNumbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        require(bonusNumber in (1..45)) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(winningNumbers.none { it == bonusNumber }) { "[ERROR] Lotto numbers must be unique." }
    }

    fun match (purchaseLotto: Lotto) : Int {
        val numbers : List<Int> = purchaseLotto.getNumbers()
        return winningNumbers.intersect(numbers.toSet()).size
    }

    fun matchBonus (purchaseLotto: Lotto) : Boolean {
        return bonusNumber in purchaseLotto.getNumbers()
    }
}