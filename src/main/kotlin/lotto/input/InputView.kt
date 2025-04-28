package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.BonusNumber
import lotto.Lotto
import lotto.PurchaseAmount
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_EMPTY_VALUE
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_INVALID_NUMBER

sealed class InputReader {

    protected fun readAndGetPurchaseAmount(): PurchaseAmount {
        println("Please enter the purchase amount")
        val amount = readPurchaseAmount()
        return PurchaseAmount(amount)
    }

    protected fun lastWeekLottoNumber(): Lotto {
        println("\nPlease enter the last week's winning numbers")
        val numbers = readLotteryTicket()
        return Lotto(numbers)
    }

    protected fun readAndGetBonusNumber(winningLotto : Lotto): BonusNumber {
        println("\nPlease enter the bonus number")
        val bonusNumber = readBonusNumber()
        return BonusNumber(bonusNumber,winningLotto)
    }

    private fun readPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        return parseNumberOrThrow(purchaseAmount)
    }


    private fun readLotteryTicket(): List<Int> {
        val lotteryNumber = Console.readLine()
        return lotteryNumber.split(",").map { it.trim()}.map { parseNumberOrThrow(it) }
    }

    private fun readBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        return parseNumberOrThrow(bonusNumber)
    }

    private fun parseNumberOrThrow(maybeNumber: String): Int{
        require(maybeNumber.isNotBlank()){ERROR_MESSAGE_EMPTY_VALUE}
        require(maybeNumber.all {it.isDigit()}){ String.format(ERROR_MESSAGE_INVALID_NUMBER, maybeNumber) }
        return maybeNumber.toInt()
    }
}

class InputView: InputReader() {
    fun getPurchaseAmount(): PurchaseAmount{
        while (true){
            try {
                return readAndGetPurchaseAmount()
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun getLottoNumber(): Lotto{
        while (true){
            try {
                return lastWeekLottoNumber()
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningLotto : Lotto): BonusNumber{
        while (true){
            try {
                return readAndGetBonusNumber(winningLotto)
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        return this === other || (other is InputView)
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}