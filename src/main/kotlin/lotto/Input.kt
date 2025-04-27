package lotto
import camp.nextstep.edu.missionutils.Console

class Input {

    //1. find number of tickets that can be purchased with the purchase amount entered
    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount: ")
                val input = Console.readLine()?.toIntOrNull()
                    ?: throw IllegalArgumentException("Purchase amount must be a valid number.")

                validatePurchaseAmount(input)

                val tickets = input / Input.DIVISIBLE_AMOUNT
                println("\nYou have purchased $tickets tickets.")
                return tickets
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }catch (e: IllegalStateException) {
                println("[testERROR] ${e.message}")
            }
        }

    }

    private fun validatePurchaseAmount(input: Int) {
        require(input > 0) { "Purchase amount must be greater than zero." }
        require(input % Input.DIVISIBLE_AMOUNT == 0) { "Purchase amount must be divisible by $Input.DIVISIBLE_AMOUNT KRW." }
    }

    companion object {
        const val LOTTO_MAX_SIZE = 6
        const val DIVISIBLE_AMOUNT = 1000
        const val RANDOM_MIN_VALUE=1
        const val RANDOM_MAX_VALUE=45

    }
}