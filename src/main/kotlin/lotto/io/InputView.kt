package lotto.io

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            println()

            try {
                return InputParser.parsePurchaseAmount(input)
            }catch (e : IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")
            val input = Console.readLine()
            println()

            try {
                return InputParser.parseWinningNumbers(input)
            }catch (e : IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun readBonusNumber(numbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number.")
            val input = Console.readLine()
            println()

            try {
                return InputParser.parseBonusNumber(input, numbers)
            }catch (e : IllegalArgumentException){
                println(e.message)
            }
        }
    }

}