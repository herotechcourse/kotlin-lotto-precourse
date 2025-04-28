package lotto.view

import camp.nextstep.edu.missionutils.Console

private const val LOTTO_PRICE = 1000
private const val LOTTO_NUMBER_COUNT = 6
private const val LOTTO_MIN_NUMBER = 1
private const val LOTTO_MAX_NUMBER = 45

class InputView {
  fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.");
    val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
    if (amount % LOTTO_PRICE !=0) {
      throw IllegalArgumentException("[ERROR] The purchase amount must be a divisible by $LOTTO_PRICE.")
    }
    return amount
  }
  
  fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
    val numbers = input.split(",").map { it.trim().toIntOrNull() }.filterNotNull()
    if (numbers.size != LOTTO_NUMBER_COUNT || numbers.any { it < LOTTO_MIN_NUMBER || it > LOTTO_MAX_NUMBER }) {
        throw IllegalArgumentException("[ERROR] Please enter exactly $LOTTO_NUMBER_COUNT valid numbers between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER.")
    }
    return numbers
  } 

  fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
    val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid bonus number.")
    if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
      throw IllegalArgumentException("[ERROR] Please enter a valid bonus number between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER.")
    }
    return bonusNumber
  }
}