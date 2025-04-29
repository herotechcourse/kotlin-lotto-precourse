package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    return Console.readLine().toIntOrNull()
      ?.takeIf { it % 1000 == 0 }
      ?: throw IllegalArgumentException("[ERROR] Amount must be a number divisible by 1000.")
  }

  fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    return Console.readLine().split(",").map { it.trim().toInt() }
  }

  fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    return Console.readLine().toInt()
  }
}