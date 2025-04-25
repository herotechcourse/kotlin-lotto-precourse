package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaeAmount(): Int {
        println("Please enter the purchase amoung.")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")

        if(amount % 1000 != 0){
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        }

        return amount
    }

}