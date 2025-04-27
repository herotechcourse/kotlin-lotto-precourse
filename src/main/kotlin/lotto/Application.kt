package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {

    private val inputView = InputView()

    fun run() {
        val amount = inputView.readPurchaseAmount()
    }
}

class InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number")
        if (amount % 100 != 0)  throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        return amount
    }
}
