package lotto.views

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int = promptAgain {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val readInput = input.toIntOrNull()

        if (readInput == null || readInput < 0 || readInput % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be positive and divisible by 1000.")
        }

        readInput
    }

    private fun <T> promptAgain(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}