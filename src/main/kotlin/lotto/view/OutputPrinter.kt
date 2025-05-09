package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult

interface OutputPrinter {
    fun printPurchasedTickets(tickets: List<Lotto>): Unit
    fun printLottoResult(lottoResult: LottoResult): Unit
    fun printErrors(reasons: List<String>): Unit
    fun printTryAgain(): Unit
    fun close(): Unit
}
