package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine().trim()
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
    require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be a positive multiple of 1,000." }
    return amount
  }

  fun readWinningNumbers(): Set<Int> {
    println("Please enter last week's winning numbers.")
    val parts = Console.readLine().split(",").map {
      it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
    }
    require(parts.size == 6) { "[ERROR] Winning numbers must be 6 unique numbers." }
    require(parts.toSet().size == 6) { "[ERROR] Winning numbers must be 6 unique numbers." }
    require(parts.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    return parts.toSet()
  }

  fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    val bonus = Console.readLine().trim().toIntOrNull()
      ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
    require(bonus in 1..45) { "[ERROR] Lotto numbers must be between 1 and 45." }
    return bonus
  }
}

