package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.util.Split
import lotto.validation.Input
import lotto.view.InputView

const val ticketCost = 1000
const val start = 1
const val end = 45

object InputReader {

    fun purchaseAmount(): Int {
        while (true) {
            InputView.purchaseAmount()
            val rawInput = Console.readLine()
            try {
                val number = Input.isPurchaseAmountValid(rawInput, ticketCost)
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