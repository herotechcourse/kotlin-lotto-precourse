package lotto

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

class WinningLotto(private val numbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(numbers.size == COUNT) { "[ERROR] WinningLotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] WinningLotto numbers must be unique." }
        for (number in numbers) {
            require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] WinningLotto number must be between 1 and 45." }
        }
        require(bonusNumber in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] BonusNumber must be between 1 and 45." }
        require(bonusNumber !in numbers) { "[ERROR] Bonus number must not be in the winning numbers." }
    }

}