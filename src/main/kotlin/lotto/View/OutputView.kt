package lotto.view

import lotto.Lotto
import lotto.LottoPrize

object OutputView {
    private val PRIZE_FORMAT = listOf(
        "3 Matches (5,000 KRW)",
        "4 Matches (50,000 KRW)",
        "5 Matches (1,500,000 KRW)",
        "5 Matches + Bonus Ball (30,000,000 KRW)",
        "6 Matches (2,000,000,000 KRW)"
    )

    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers().joinToString(prefix = "[", postfix = "]", separator = ", "))
        }
    }

    fun printWinningStatics(result: List<Int>, amount: Int) {
        println("Winning Statistics")
        println("---")

        for(i in 0 until result.size) {
            println("${PRIZE_FORMAT[i]} – ${result[i]} tickets")
        }

        val returnRate = calculateReturnRate(result, amount)
        println("Total return rate is ${"%.1f".format(returnRate)}%.")
    }

    private fun calculateReturnRate(result: List<Int>, amount: Int): Double {
        var total = 0
        for(i in 0 until result.size) {
            total += (LottoPrize.values()[i].prize * result[i])
        }
        return (total.toDouble() / amount) * 100
    }
}