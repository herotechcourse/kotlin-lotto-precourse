package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.Config

object InputView {
    private val lottoLength = Config.LENGTH_OF_LOTTO
    private val minNumber = Config.MIN_LOTTO_NUMBER
    private val maxNumber = Config.MAX_LOTTO_NUMBER

    fun readPurchaseAmount(): Int {
        val pricePerTicket = Config.PRICE_PER_TICKET
        return readIntOrNull()
            ?.takeIf { it > 0 && it % pricePerTicket == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by $pricePerTicket.")
    }

    fun readWinningNumbers(): List<Int> {
        return Console.readLine()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input.") }
            .also {
                require(it.size == lottoLength) { "[ERROR] Must provide $lottoLength numbers."}
                require(it.distinct().size == lottoLength) { "[ERROR] Numbers must not be duplicated."}
                require(it.all { n -> n in minNumber..maxNumber }) { "[ERROR] All numbers must be in between $minNumber and $maxNumber."}
            }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        return readIntOrNull()
            ?.also {
                require(!winningNumbers.contains(it)) { "[ERROR] Bonus number must not a duplicated from the winning numbers." }
                require(it in minNumber..maxNumber) { "[ERROR] Bonus number must be in between $minNumber and $maxNumber." }
            }
            ?: throw IllegalArgumentException("[ERROR] Invalid input.")
    }

    fun showInstruction(instruction: String) = println(instruction)

    private fun readIntOrNull() = Console.readLine().trim().toIntOrNull()
}