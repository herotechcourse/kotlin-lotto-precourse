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

    fun readWinningNumbers(): List<Int> {
        println("Winning numbers (comma-separated):")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
        if (numbers.size != 6 || numbers.distinct().size != 6){
            throw IllegalArgumentException("[ERROR] 6 unique numbers required.")
        }
        if (numbers.any( {it -> it !in 1..45} )){
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        return numbers
    }

    fun readBonusNumber(): Int{
        println("Bonus number:")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid bonus number.")
        if(bonus !in 1 ..45 ){
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        return bonus
    }
}

