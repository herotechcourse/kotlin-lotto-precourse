package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
  fun readPurchaseAmount(): Int {
    while (true) {
      try {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        val amount = input.toInt()
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1,000." }
        return amount
      } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
      }
    }
  }

  fun readWinningNumbers(): List<Int> {
    while (true) {
      try {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine().trim()
        val numbers = input.split(",").map { it.trim().toInt() }
        require(numbers.size == 6) { "Enter exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "Lotto numbers must be between 1 and 45." }
        return numbers
      } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
      }
    }
  }

  fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
      try {
        println("Please enter the bonus number.")
        val bonus = Console.readLine().trim().toInt()
        require(bonus in 1..45) { "Bonus number must be between 1 and 45." }
        require(bonus !in winningNumbers) { "Bonus number must not be among winning numbers." }
        return bonus
      } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
      }
    }
  }
}
