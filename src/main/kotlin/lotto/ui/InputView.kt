package lotto.ui

import camp.nextstep.edu.missionutils.Console

class InputView {

    companion object {
        fun readAndGetPurchaseAmount(): Long {
            println("Please enter the purchase amount.")
            val purchaseNumberInput = Console.readLine()
            if (purchaseNumberInput == null || !purchaseNumberInput.matches(Regex("\\d+"))) {
                throw IllegalArgumentException("[ERROR] Please enter digits only.")
            }
            println()
            return purchaseNumberInput.toLong()
        }
    }
}