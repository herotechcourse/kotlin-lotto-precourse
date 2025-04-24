package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchaseAmount():Int {

        while (true) {
            try {
                Messages.display(Messages.PURCHASE_AMOUNT)
                val input = Console.readLine()
                return Validator.validatePurchaseAmount(input)
            }
            catch (e: IllegalArgumentException) {
                Messages.display(Messages.ERROR,
                    e.message ?: Messages.ERROR_INVALID_INPUT)
            }
        }
    }

}