package lotto

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    // TODO: Implement the program



    val inputView = InputView()

    val ticketNumber = inputView.readPurchase()
    val lottoWinningNumbers = inputView.promptWinningNumbers()

    val ticketGeneration = LottoTicketGeneration(ticketNumber)
    ticketGeneration.generateTicket()
    ticketGeneration.showTickets()
    val tickets = ticketGeneration.tickets

//    for (ticket in tickets) {
//        val prize = ticket.checkPrize(lottoWinningNumbers)
//        println(prize.name)
//    }

    val winningStatistics = WinningStatistics(tickets, lottoWinningNumbers)
    winningStatistics.getMapPrize()
    val mapNumberPrize = winningStatistics.mapPrizeNumber
    println(mapNumberPrize)
    println(winningStatistics.getTotalMoney())
    println(winningStatistics.getMoneyEach())

    val outputView = OutputView(tickets, lottoWinningNumbers)
    outputView.printOutput()

//    val winningNumber = inputView.readWinningNumber()
//    val bonusNumber = inputView.readBonusNumber()
//    if (inputView.checkBonusNumber(winningNumber, bonusNumber)) {
//        throw IllegalArgumentException("[ERROR] Bonus number must not be in the Winning Number")
//    }

    // println(amountMoney)
}
