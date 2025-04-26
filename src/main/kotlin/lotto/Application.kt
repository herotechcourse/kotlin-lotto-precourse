package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat

fun main() {
    val lottoProgram = LottoProgram()
    lottoProgram.run()
}

class LottoProgram {
    companion object {
        private const val LOTTO_PRICE = 1000
    }

    fun run() {
        try {
            val purchaseAmount = getPurchaseAmount()
            val lottos = purchaseLottos(purchaseAmount)

            printPurchasedLottos(lottos)

            val winningNumbers = getWinningNumbers()
            val bonusNumber = getBonusNumber(winningNumbers)

            val results = calculateResults(lottos, winningNumbers, bonusNumber)
            printWinningStatistics(results, purchaseAmount)

        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        try {
            val amount = input.toInt()
            validatePurchaseAmount(amount)
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a number.")
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        }
        if (amount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }

    private fun purchaseLottos(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE
        return List(count) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it) }
        println()
    }

    private fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            validateWinningNumbers(numbers)
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be valid integers.")
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must contain exactly 6 numbers.")
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        println()
        println("Please enter the bonus number.")
        val input = Console.readLine()

        try {
            val bonusNumber = input.toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
        }
    }

    private fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (winningNumbers.contains(number)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be among the winning numbers.")
        }
    }
enum class LottoRank(
    val matchCount: Int,
    val hasBonus: Boolean,
    val prize: Long,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, "6 Matches"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball"),
    THIRD(5, false, 1_500_000, "5 Matches"),
    FOURTH(4, false, 50_000, "4 Matches"),
    FIFTH(3, false, 5_000, "3 Matches"),
    NONE(0, false, 0, "No Match");

    companion object {
        fun calculateRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}