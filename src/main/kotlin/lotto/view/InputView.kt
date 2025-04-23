package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000" }
        return amount
    }

}
