package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.");
    val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
    if (amount % 1000 !=0) {
      throw IllegalArgumentException("[ERROR] The purchase amount must be a divisible by 1000.")
    }
    return amount
  }
  
  fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
    val numbers = input.split(",").map { it.trim().toIntOrNull() }
    if (numbers.size != 6 || numbers.any { it == null } || numbers.any { it!! < 1 || it!! > 45 }) {
      throw IllegalArgumentException("[ERROR] Please enter exactly 6 valid winning numbers.")
    }
    return numbers
  } 
}