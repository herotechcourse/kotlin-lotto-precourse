package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchaseAmount():Int {

        while (true) {
            try {
                Message.display(Message.PURCHASE_AMOUNT)
                val input = Console.readLine()
                return Validator.validatePurchaseAmount(input)
            }
            catch (e: IllegalArgumentException) {
                Message.display(Message.ERROR,
                    e.message ?: Message.ERROR_INVALID_INPUT)
            }
        }
    }

}