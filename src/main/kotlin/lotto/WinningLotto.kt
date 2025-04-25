package lotto

class WinningLotto (private val winningNumbers: List<Int>, private val bonusNumber: Int){
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain 6 numbers." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }
}