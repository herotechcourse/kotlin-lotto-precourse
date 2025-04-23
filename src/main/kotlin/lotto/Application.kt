package lotto

import camp.nextstep.edu.missionutils.Console

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application().purchaseAmount()
        }
    }

    private fun purchaseAmount():Long? {
        println("Please enter the purchase amount.")
        val input = Console.readLine()?.trim()
        val purchaseLotto = input?.toLongOrNull()
        validatePurchaseAmount(purchaseLotto)
        return purchaseLotto
    }

    private fun validatePurchaseAmount(purchaseLotto: Long?) {
        if (purchaseLotto == null) {
            throw IllegalArgumentException("[ERROR] Amount cannot be empty and must be a valid number")
        }
        if (purchaseLotto == 0L) {
            throw IllegalArgumentException("[ERROR] Amount cannot be zero")
        }
        if (purchaseLotto % 1000L != 0L) {
            throw IllegalArgumentException("[ERROR] Amount must be a multiply of 1000")
        }
    }
}
