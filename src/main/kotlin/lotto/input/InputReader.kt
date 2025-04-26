package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.util.Split
import lotto.validation.Input
import lotto.view.InputView

const val ticketCost = 1000
const val start = 1
const val end = 45

object InputReader {

    fun purchaseAmount(): Int {
        InputView.purchaseAmount()
        val rawInput = Console.readLine()
        Input.isEmpty(rawInput)
        Input.isInteger(rawInput)
        Input.isPositiveInteger(rawInput.toInt())
        Input.isDivisible(rawInput.toInt(), ticketCost)
        return rawInput.toInt()
    }

    fun winningNumbers(): List<Int> {
        InputView.winningNumbers()
        val rawInput = Console.readLine()
        Input.isEmpty(rawInput)
        val rawNumbers = Split.byComma(rawInput).map { it.trim() }
        Input.isEachInteger(rawNumbers)
        val numbers = rawNumbers.map { it.toInt() }
        Input.isEachInRange(numbers, start, end)
        Input.winningNumbersDuplication(numbers)
        return numbers
    }

    fun bonusNumber(numbers: List<Int>): Int {
        InputView.bonusNumber()
        val rawInput = Console.readLine()
        Input.isEmpty(rawInput)
        Input.isInteger(rawInput)
        Input.isInRange(rawInput.toInt(), start, end)
        Input.bonusNumberDuplication(rawInput.toInt(), numbers)
        return rawInput.toInt()
    }

}