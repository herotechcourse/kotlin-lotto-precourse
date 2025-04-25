package lotto
import camp.nextstep.edu.missionutils.Console

class InputView() {

    fun getPurchaseInput(): Int {

        var purchaseAmount: Int
        while (true) {
            val input = readOneLine(PromptMessages.PURCHASE_AMOUNT.message)
            try {
                purchaseAmount = validatePurchaseInput(input)
                break
            } catch (e: IllegalArgumentException) {
                println("Error: ${e.message}")
            }
        }

        return purchaseAmount
    }

    private fun validatePurchaseInput(input: String): Int {

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(PurchaseErrorMessage.NOT_A_NUMBER.message)
        if (amount < 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NEGATIVE_NUMBER.message)
        }
        if (amount < 1000) {
            throw IllegalArgumentException(PurchaseErrorMessage.LESS_THAN_MINIMUM.message)
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NOT_A_MULTIPLE_OF_1000.message)
        }

        return amount
    }

    fun readOneLine(prompt: String): String {
        println(prompt)
        return Console.readLine()
    }
}

