package lotto.models

import lotto.Lotto

class WinningLotto(
    val ticket: Lotto,
    val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in ticket.getNumbers()) {
            "[ERROR] Bonus number must not be one of the winning numbers."
        }
    }
}
