package lotto.models

import lotto.models.Lotto

class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers.getNumbers()) {
            "[ERROR] Bonus number must not be one of the winning numbers."
        }
    }
}
