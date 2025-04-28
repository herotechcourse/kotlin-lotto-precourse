import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val input = Console.readLine()

        return validatePurchaseAmount(input)
    }

    private fun validatePurchaseAmount(input: String): Int {
        try {
            val amount = input.toInt()
            require(amount > 0) { "[ERROR] Purchase amount must be a positive number." }
            require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
    }
}