package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.BonusNumber
import lotto.Lotto
import lotto.PurchaseAmount

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
        require(maybeNumber.isNotBlank()){"[ERROR] Input must not contain empty value"}
        require(maybeNumber.all {it.isDigit()}){ "[ERROR] Invalid number entered for $maybeNumber" }
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
                return lastWeekLottoNumber();
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
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }
}