package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
  fun readPurchaseAmount(): Long {
    println("Please enter the purchase amount.")
    try {
      return Console.readLine().toLong()
    } catch (e: NumberFormatException) {
      throw IllegalArgumentException("[ERROR] Invalid purchase amount format.")
    }
  }

  fun readWinningNumbers(): List<Int> {
    println()
    println("Please enter the winning numbers.")
    try {
      val input = Console.readLine()
      return input.split(",").map { it.trim().toInt() }
    } catch (e: NumberFormatException) {
      throw IllegalArgumentException("[ERROR] Invalid winning numbers format.")
    }
  }

  fun readBonusNumber(): Int {
    println()
    println("Please enter the bonus number.")
    try {
      return Console.readLine().toInt()
    } catch (e: NumberFormatException) {
      throw IllegalArgumentException("[ERROR] Invalid bonus number format.")
    }
  }
}