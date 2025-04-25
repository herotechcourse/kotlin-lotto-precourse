package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.error.ExceptionMessage

class InputView {

    fun askPurchaseAmount(): PurchaseAmountDto {
        return PurchaseAmountDto(readInt())
    }

    fun askWinningNumbers() : WinningNumbersDto {
        return WinningNumbersDto(readIntList())
    }

    fun askBonusNumber(): BonusNumberDto {
        return BonusNumberDto(readInt())
    }

    private fun readLineWithoutSpace(): String {
        return Console.readLine().trim()
    }

    private fun readInt(): Int {
        val input: Int
        try {
            input = readLineWithoutSpace().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_A_NUMBER.errorMessage)
        }
        return input
    }

    private fun readIntList(): List<Int> {
        val input: List<Int>
        try {
            input = readLineWithoutSpace().trim().split(",").map {it.trim().toInt()}
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_A_NUMBER.errorMessage)
        }
        return input
    }
}
