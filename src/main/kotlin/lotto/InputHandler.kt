package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getPurchaseAmount():Int{
        while(true){
            try{
                println("Please enter the purchase amount.")
                val input = Console.readLine().trim()
                val amount = input.toInt()
                require(amount % 1000 == 0) { "Purchase amount must be divisible by 1000 but $amount is not" }
                return amount
            }catch (e: NumberFormatException){
                println("[ERROR] Please enter a valid number.")
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }
}