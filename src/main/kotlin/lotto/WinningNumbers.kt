package lotto

class WinningNumbers(val winningNumbers: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.getNumbers().contains(bonusNumber)) {
            "[ERROR] Bonus number must not duplicate a winning number."
        }
    }
}
