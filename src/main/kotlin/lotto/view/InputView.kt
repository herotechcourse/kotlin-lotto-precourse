package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.ExceptionMessage


class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount")
        val input = Console.readLine()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_FORMAT.message)
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter week`s winning numbers")
        val input = Console.readLine()
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.message)
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number")
        val input = Console.readLine()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_FORMAT.message)
        }
    }
}