package lotto.domain

import lotto.view.InputView

class BonusNumber(number: Int) {
    companion object {
        fun from(input: String): BonusNumber {
            return BonusNumber(input.toInt())
        }
    }
}