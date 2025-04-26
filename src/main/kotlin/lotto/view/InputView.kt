package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Validator
import lotto.constants.InputMessage

object InputView {
    fun getPurchaseAmount(): Int {
        return try {
            println(InputMessage.PURCHASE.message)
            val input: String = Console.readLine()

            return Validator.validatePurchaseAmount(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
    }
}