package lotto.domain

class WinningNumbers(val numbers: List<Int>, val bonusNumber: Int) {

    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
}
