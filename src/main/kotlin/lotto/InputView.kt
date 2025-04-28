package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    private fun validatePurchaseAmount(purchaseAmount: Int?) {
        requireNotNull(purchaseAmount) { "[ERROR] The amount must be a valid number." }
        require(purchaseAmount > 0) { "[ERROR] The amount must be a valid number." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] The amount must be divisible by 1,000." }
    }

    fun readPurchaseAmount(): Int {
        print("Purchase amount for lottery tickets: ")
        val input = Console.readLine().toIntOrNull()
        validatePurchaseAmount(input)
        return input!!
    }
}