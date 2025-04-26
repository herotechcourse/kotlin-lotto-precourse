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

    fun getWinningNumbers():List<Int>{
        while (true){
            try {
                println("Please enter last week's winning numbers (comma-separated).")
                val input = Console.readLine().trim()
                val numbers = input.split(",")
                    .map{it.trim().toInt()}
                    .distinct()
                require(numbers.size == 6){"Please enter exactly 6 unique numbers."}
                return numbers

            }catch (e: NumberFormatException){
                println("[ERROR] Please enter valid numbers.")
            }catch (e: IllegalArgumentException){
                println("[ERROR] ${e.message}")
            }
        }
    }
}