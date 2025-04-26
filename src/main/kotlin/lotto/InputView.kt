package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.collections.any
import kotlin.collections.distinct
import kotlin.collections.map
import kotlin.text.split
import kotlin.text.toIntOrNull
import kotlin.text.trim

object InputView {
    fun readPurchaseAmount(): Int{
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw kotlin.IllegalArgumentException("[ERROR] Please enter a valid number.")
        if (amount % 1000 != 0){
            throw kotlin.IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
        return amount
    }

}

