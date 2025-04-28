package lotto.view

import camp.nextstep.edu.missionutils.Console;

object InputView{
  fun readPurchaseAmount(): Int{
    println("Please enter the purchase amount.")
    val input = Console.readLine()?: throw IllegalArgumentException("[ERROR] Purchase amount must be provided.")
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Purchase amount must be number") // input to number
    require(amount>0 && amount % 1000==0){
      "[ERROR] purchase amount must be a positive multiple of 1000"
    }
    return amount;
  }

  fun readWinningNumbers(): Set<Int>{
    println("Please enter last week's winning numbers.")
    val nums = Console.readLine().split(",").map { it.toInt() }
    require(nums.size==6 && nums.toSet().size==6 && nums.all { it in 1..45 } ){
      "[ERROR] Enter exactly 6 unique numbers between 1 and 45."
    }
    return nums.toSet()
  }

  fun readBonusNumber(winning: Set<Int>):Int{
    println("Please enter the bonus number.")
    val bonus = Console.readLine().toIntOrNull()?: throw IllegalArgumentException("[ERROR] Bonus number must be a number")
    require(bonus in 1..45 && bonus !in winning){
      "[ERROR] Bonus number must be between 1 and 45 and not duplicate winning numbers."
    }
    return bonus;
  }



}