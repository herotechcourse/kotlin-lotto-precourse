package lotto

import java.text.DecimalFormat

class OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it) }
        println()
    }

    fun printWinningStatistics(results: Map<LottoRank, Int>, purchaseAmount: Int) {
        println()
        println("Winning Statistics")
        println("---")

        val displayRanks = listOf(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
        )

        displayRanks.forEach { rank ->
            val count = results.getOrDefault(rank, 0)
            println("${rank.description} (${formatMoney(rank.prize)} KRW) – ${count} tickets")
        }

        val lottoService = LottoService()
        val totalPrize = lottoService.calculateTotalPrize(results)
        val profitRate = lottoService.calculateProfitRate(totalPrize, purchaseAmount)

        println("Total return rate is ${formatRate(profitRate)}%.")
    }

    fun printError(message: String) {
        println(message)
    }

    private fun formatMoney(amount: Long): String {
        val formatter = DecimalFormat("#,###")
        return formatter.format(amount)
    }

    private fun formatRate(rate: Double): String {
        val formatter = DecimalFormat("#,##0.0")
        return formatter.format(rate)
    }
}