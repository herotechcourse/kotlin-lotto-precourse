package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.domain.TICKET_COST
import lotto.validation.Input
import lotto.view.InputView

object InputReader {

    fun purchaseAmount(): Int {
        while (true) {
            InputView.purchaseAmount()
            val rawInput = Console.readLine()
            try {
                val number = Input.isPurchaseAmountValid(rawInput, TICKET_COST)
                return number
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun winningNumbers(): Lotto {
        while (true) {
            InputView.winningNumbers()
            val rawInput = Console.readLine()
            try {
                val numbers = Input.isWinningNumbersValid(rawInput)
                val winningTicket = Lotto(numbers)
                return winningTicket
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumber(numbers: List<Int>): Int {
        while (true) {
            InputView.bonusNumber()
            val rawInput = Console.readLine()
            try {
                val number = Input.isBonusNumberValid(rawInput, numbers)
                return number
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

}