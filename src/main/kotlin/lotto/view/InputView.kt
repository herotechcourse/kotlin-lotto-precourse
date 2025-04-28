package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.utils.Exceptions.validateBonusNumber
import lotto.utils.Exceptions.validatePurchaseAmount
import lotto.utils.Exceptions.validateWinningNumbers

class InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            validatePurchaseAmount(Console.readLine().trim())
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }

    fun inputWinningNumber(): Lotto {
        while (true) {
            validateWinningNumbers(Console.readLine().trim().split(","))
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }

    fun inputBonusNumber(winningNumber: Lotto): Int {
        while (true) {
            validateBonusNumber(winningNumber = winningNumber, bonusNumber = Console.readLine().trim())
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }
}