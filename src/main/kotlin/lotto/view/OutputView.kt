package lotto.view

import lotto.domain.LottoRank
import lotto.domain.Lottos

object OutputView {
    private const val ERROR_HEAD = "[ERROR]"
    private const val GENERATED_LOTTO_HEADER = "You have purchased %d tickets."
    private const val MATCHED_LOTTO_COUNT_HEADER = "\nWinning Statistics\n---";
    private const val MATCHED_LOTTO_COUNT = "%s – %d tickets"
    private const val PROFIT_RATE_HEADER = "Total return rate is %.1f%%.";

    fun printError(message: String) {
        println("$ERROR_HEAD $message")
    }

    fun printGeneratedLottos(lottos: Lottos) {
        println("\n${GENERATED_LOTTO_HEADER.format(lottos.tickets.size)}")

        lottos.tickets.forEach {
            println(it.formatForDisplay())
        }
    }

    fun printMatchedLottoCount(matchedLottoCount: Map<LottoRank, Int>) {
        println(MATCHED_LOTTO_COUNT_HEADER)

        LottoRank.entries
            .filter { it != LottoRank.NONE }
            .reversed()
            .forEach { rank ->
                val count = matchedLottoCount[rank] ?: 0
                println(MATCHED_LOTTO_COUNT.format(rank.message, count))
            }
    }

    fun printProfitRate(profitRate: Double) {
        println(PROFIT_RATE_HEADER.format(profitRate))
    }
}