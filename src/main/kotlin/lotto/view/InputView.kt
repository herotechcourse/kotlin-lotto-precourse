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
}