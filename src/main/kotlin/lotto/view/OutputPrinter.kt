package lotto.view

import lotto.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoResult
import lotto.domain.Rank

interface OutputPrinter {
    fun printPurchasedTickets(tickets: List<Lotto>): Unit
    fun printLottoResult(lottoResult: LottoResult): Unit
    fun close(): Unit
}
