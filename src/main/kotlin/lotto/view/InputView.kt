package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchase() : String {
        println("Enter the price")
        val input = Console.readLine()
        println(input)
        validateInput(input)
        return input
    }

    private fun validateInput(input:String) {
        require(input.all {it.isDigit()}) { "[ERROR] Input must be numeric." }
        val amount = try {
            input.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The amount is not within a realistic range.")
        }
        require(amount % 1000 == 0L) { "[ERROR] Amount must be divisible by 1,000."}
    }
}
