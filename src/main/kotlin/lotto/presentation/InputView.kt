package lotto.presentation

import camp.nextstep.edu.missionutils.Console

object InputView {

  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine()
    return input.toIntOrNull()?.also {
      require(it >= 1000 && it % 1000 == 0) {
        "[ERROR] Amount must be at least 1000 and divisible by 1000."
      }
    } ?: throw IllegalArgumentException("[ERROR] Amount must be integer.")
  }


  fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers (comma-separated).")
    val input = Console.readLine()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }

    require(numbers.size == 6) {
      "[ERROR] You must enter exactly 6 numbers."
    }
    require(numbers.toSet().size == 6) {
      "[ERROR] Duplicate numbers are not allowed."
    }
    require(numbers.all { it in 1..45 }) {
      "[ERROR] Lotto numbers must be between 1 and 45."
    }

    return numbers.sorted()
  }


  fun readBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")

    require(bonus in 1..45) {
      "[ERROR] Bonus number must be between 1 and 45."
    }
    require(!winningNumbers.contains(bonus)) {
      "[ERROR] Bonus number must not be part of the winning numbers."
    }

    return bonus
  }



}
