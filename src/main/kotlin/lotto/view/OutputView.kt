package lotto.view

import lotto.Lotto

class OutputView {
    fun askPurchaseAmount() {
        println("Please enter the purchase amount")
    }

    fun printPurchasedLottoTicket(purchasedQuantity: Int, lottoTicket: List<Lotto>) {
        println()
        println("You have purchased $purchasedQuantity tickets.")
        lottoTicket.map { lotto ->
            LottoTicketDto(lotto.getNumbers())
        }.forEach {
            println(it.numbers)
        }
        println()
    }

    fun askWinningNumbers() {
        println("Please enter last week's winning numbers.")
    }

    fun askBonusNumber() {
        println()
        println("Please enter the bonus number.")
    }

    fun printWinningStatistics(matchResultDto: MatchResultDto, returnRate: Double) {
        println()
        println("Winning Statistics")
        println("---")
        println(matchResultDto.output)
        println()
        println("Total return rate is ${String.format("%.1f", returnRate)}%.")
    }
}