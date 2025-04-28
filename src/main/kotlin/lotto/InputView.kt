package lotto

import camp.nextstep.edu.missionutils.Console

class InputView(
    private val readLine: () -> String = { Console.readLine() } // default = real Console
) {

    val lotteryMachine = LotteryMachine()

    fun readPurchaseAmount(): List<Lotto> {
        println("Please enter the purchase amount")
        val input = readLine()
        return try {
            lotteryMachine.purchaseTickets(input)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_FORMAT.message)
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = readLine()
        return input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.message) }
            .also { if (it.size != 6) throw IllegalArgumentException(ExceptionMessage.INVALID_WINNING_LOTTO_SIZE.message) }
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readLine()
        return input.trim()
            .toIntOrNull()
            ?.also { if (it !in 1..45) throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_RANGE.message) }
            ?: throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_FORMAT.message)
    }
}
