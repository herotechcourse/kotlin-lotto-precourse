package lotto

import camp.nextstep.edu.missionutils.Randoms


fun main() {

    val inputView = InputView()

    val ticketNumber = inputView.readPurchase()
    val lottoWinningNumbers = inputView.promptWinningNumbers()

    val lottoTickets = LottoTicketGeneration.generateTicket(ticketNumber)
//    ticketGeneration.generateTicket()
//    ticketGeneration.showTickets()
//    val tickets = ticketGeneration.tickets

//    for (ticket in tickets) {
//        val prize = ticket.checkPrize(lottoWinningNumbers)
//        println(prize.name)
//    }

    val winningStatistics = WinningStatistics(lottoTickets, lottoWinningNumbers)
    winningStatistics.getMapPrize()
//    val mapNumberPrize = winningStatistics.mapPrizeNumber
//    println(mapNumberPrize)
//    println(winningStatistics.getTotalMoney())
//    println(winningStatistics.getMoneyEach())

    val outputView = OutputView(lottoTickets, lottoWinningNumbers)
    outputView.printOutput()


}
