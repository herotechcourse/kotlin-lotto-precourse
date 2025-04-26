package lotto.presentation.view

import camp.nextstep.edu.missionutils.Console
import lotto.presentation.constants.InputErrorMessages

object InputView {

  fun readPurchaseAmount(): Int {
    while (true) {
      try {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()?.also {
          require(it >= 1000 && it % 1000 == 0) {
            InputErrorMessages.ERROR_AMOUNT_INVALID
          }
        } ?: throw IllegalArgumentException(InputErrorMessages.ERROR_AMOUNT_INTEGER)
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
  }


  fun readWinningNumbers(): List<Int> {
    while (true) {
      try {
        println("Please enter last week's winning numbers (comma-separated).")
        val input = Console.readLine()
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }

        require(numbers.size == 6) { InputErrorMessages.ERROR_WINNING_NUMBERS_SIZE }
        require(numbers.toSet().size == 6) { InputErrorMessages.ERROR_DUPLICATE_NUMBERS }
        require(numbers.all { it in 1..45 }) { InputErrorMessages.ERROR_NUMBER_RANGE }

        return numbers.sorted()
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
  }
  fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
      try {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException(InputErrorMessages.ERROR_BONUS_INVALID)

        require(bonus in 1..45) { InputErrorMessages.ERROR_BONUS_RANGE }
        require(!winningNumbers.contains(bonus)) { InputErrorMessages.ERROR_BONUS_DUPLICATE }

        return bonus
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
  }
}
