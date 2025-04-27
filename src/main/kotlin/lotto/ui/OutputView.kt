package lotto.ui

import lotto.Lotto
import lotto.LottoResult
import lotto.PurchaseAmount

object OutputView {
    private const val PURCHASED_TICKETS_MESSAGE = "You have purchased %d tickets."
    private const val WINNING_STATICS_OUTPUT_MESSAGE = "Winning Statistics\n" + "---"
    private const val TICKET_RESULT_MESSAGE = "%s (%s KRW) – %d tickets"

    fun printLotteryTicketsOutputMessage(purchaseAmount: PurchaseAmount, lottoList: List<Lotto>) {
        println()
        println(PURCHASED_TICKETS_MESSAGE.format(purchaseAmount.ticketCount))
        lottoList.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printWinningStatisticsOutputMessage(lottoResult: LottoResult) {
        println(WINNING_STATICS_OUTPUT_MESSAGE)
        lottoResult.getResult().forEach { result ->
            println(
                TICKET_RESULT_MESSAGE.format(
                    result.key.message, String.format("%,d", result.key.prize), result.value
                )
            )
        }
    }
}