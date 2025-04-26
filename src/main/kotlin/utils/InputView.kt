package utils

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

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
                    println("${e.message}")
                }
            }

        }
        fun getWinningNumbers():Lotto{
            while (true){
                try {
                    println("Please enter last week's winning numbers.")
                    var winningNumbers = Console.readLine()
                    return Lotto.generateWinningLotto(winningNumbers)
                }catch (e:IllegalArgumentException){
                    println("${e.message}")
                }
            }
        }
        fun getBonusNumber():Int{
            while (true){
                try {
                    println("Please enter the bonus number.")
                    val bonusNumber = Console.readLine()
                    return InputValidator.validateBonusNum(bonusNumber)
                }catch (e:IllegalArgumentException){
                    println("${e.message}")
                }
            }

        }

    }
}