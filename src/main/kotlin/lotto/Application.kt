package lotto

fun main() {

    var inputView = InputView()
    var prize:Int = 0

    for(ticket in inputView.tickets) {
        val lotto = Lotto(ticket)
        var prizeNumber = lotto.findMatches(inputView.getWinningNumber(), inputView.getBonusNumber())
        prize += prizeNumber.prizeMoney // add all the price together
    }

    println(prize)

}

