package utils

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object{
        fun getAmount():Int{
            while(true){
                try {
                    println("Please enter the purchase amount")
                    val input = Console.readLine()
                    var ticketCount = InputValidator.validate(input)
                    println("You have purchased ${ticketCount} tickets.")
                    return ticketCount
                }catch (e:IllegalArgumentException){
                    println("Error: ${e.message}")
                }
            }

        }

    }
}