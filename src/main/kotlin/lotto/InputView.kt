package lotto

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.internal.ErrorMessages

class InputView {
    private fun input(): String {
        return Console.readLine().trim()
    }

    private fun readInt(): Int {
        val input: Int
        try {
            input = input().toInt()
        } catch(e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_A_NUMBER.errorMessage)
        }
        return input
    }

    fun askPurchaseAmount() : PurchaseAmountDto{
        return PurchaseAmountDto(readInt())
    }

    fun askBonusNumber() : BonusNumberDto {
        return BonusNumberDto(readInt())
    }
}
