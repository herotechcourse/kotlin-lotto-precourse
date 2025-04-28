package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val line = Console.readLine().trim()
        val amount = try {
            line.toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR] Purchase amount must be a valid integer.")
            throw IllegalArgumentException("[ERROR] Purchase amount must be a valid integer.")
        }
        Purchase(amount)
        return amount
    }
    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated)." )
        return LottoInput.parseWinningNumbers(Console.readLine())
    }
    fun readBonusNumber(winning: List<Int>): Int {
        println("Please enter the bonus number.")
        return LottoInput.parseBonusNumber(Console.readLine(), winning)
    }
}