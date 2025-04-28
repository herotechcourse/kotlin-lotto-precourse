package lotto.controller

import lotto.domain.LotteryTicket
import lotto.view.InputReader
import lotto.view.OutputPrinter

class LottoController(private val reader: InputReader, private val printer: OutputPrinter) {
    fun run(): Unit {
        // 1. Input purchase amount for buy the lottery tickets.
        val purchaseAmount = reader.readPurchaseAmount()
        // 2. Print purchased lottery tickets with issued numbers (sorted)

        // 3. Input last week's numbers
        // 4. Input a bonus number.
        // 5. Print lotto result statistics.
        // 6. Print calculated Profit rate.this.
        printer.close()
    }

    companion object {
        private const val TICKET_PRICE: Int = LotteryTicket.PRICE
    }
}
