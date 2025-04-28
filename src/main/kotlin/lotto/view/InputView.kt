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
}