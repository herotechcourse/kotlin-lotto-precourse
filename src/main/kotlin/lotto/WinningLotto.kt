package lotto

data class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(!winningNumbers.contains(bonusNumber)) { "The bonus number must be different from the winning numbers." }
    }
}
