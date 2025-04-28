package lotto

import camp.nextstep.edu.missionutils.Console

class MoneyInput(private val testInputProvider: (() -> String)? = null)
{
    fun inputMoneyAmount(): Int {
        while (true){
            val amount = inputAndError()
            if (amount != 0)
                return (amount)
        }
    }

    private fun userOrTestInput(): String {
        if (testInputProvider == null)
            return Console.readLine()
        val providedInput = testInputProvider.invoke()
        if (providedInput.isNotEmpty())
            return providedInput
        return "1000"
    }

    private fun inputAndError(): Int {
        try {
            return inputTaker()
        } catch (_: NumberFormatException) {
            println("[ERROR] Input must be fully numeric.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return 0
    }

    private fun inputTaker() : Int {
        println("Please enter the purchase amount.")
        val input = userOrTestInput()
        val amount = input.toInt()
        validateAmount(amount)
        return amount
    }

    private fun validateAmount(amount: Int) {
        if (amount % 1000 != 0)
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        if (amount <= 0)
            throw IllegalArgumentException("[ERROR] Amount must be a positive number.")
    }
}

