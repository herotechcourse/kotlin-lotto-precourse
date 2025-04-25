package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a valid number")

        if (amount % 10000 != 0 ) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1, 000. ")
        }
        return  amount
    }
}