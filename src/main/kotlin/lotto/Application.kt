package lotto

fun main() {

    var inputView = InputView()
    inputView.initPrintTicket()

    var prize:Int = 0
    var prizeList: MutableList<Prize> = mutableListOf()
    for(ticket in inputView.getTickets()) {
        val lotto = Lotto(ticket)
        var prizeNumber = lotto.findMatches(inputView.getWinningNumber(), inputView.getBonusNumber())
        prizeList.add(prizeNumber)
        prize += prizeNumber.prizeMoney // add all the price together
    }
    OutputView.printPrizeStatics(prizeList)
    OutputView.calculatePrintRate(prize, inputView.getPurchaseAmount())
}

