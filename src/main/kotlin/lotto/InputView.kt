package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine()
    return input.toIntOrNull()?.takeIf { it % 1000 == 0 && it > 0 }
      ?: throw IllegalArgumentException("[ERROR] Amount must be a positive multiple of 1,000.")
  }

  fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()
    val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.") }
    if (numbers.size != 6 || numbers.toSet().size != 6) throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers.")
    if (numbers.any { it !in 1..45 }) throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
    return numbers
  }

  fun readBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
    if (bonus !in 1..45) throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
    if (bonus in winningNumbers) throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
    return bonus
  }
}