package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        val inputView = InputView()
        val outputView = OutputView()

        val purchaseAmount = inputView.getPurchaseAmount()
        validatePurchaseAmount(purchaseAmount)
        val ticketNum: Int = numberOfTickets(purchaseAmount)
        outputView.displayTicketNumber(ticketNum)

        val tickets: List<List<Int>> = ticketsGenerator(ticketNum)
        outputView.displayTickets(tickets)

        val winningNumbers = inputView.getWinningNumbers()
        val lotto = Lotto(winningNumbers)
        val bonusNumber = getBonusNumber(inputView, lotto)

        val matchResults = lotto.checkMatchingNumbers(tickets, bonusNumber)
        val totalPrize = lotto.calculateTotalPrize(matchResults)
        val returnRate = lotto.calculateReturnRate(purchaseAmount, totalPrize)

        outputView.displayWinningResults(matchResults, returnRate)
    } catch (e: Exception) {
        println(e.message)
    }
}

private fun validatePurchaseAmount(purchaseAmount: Int) {
    if (purchaseAmount < 1000) {
        throw IllegalArgumentException("[ERROR] The purchase amount must be 1000 or higher")
    }
}

private fun getBonusNumber(inputView: InputView, lotto: Lotto): Int {
    val bonusNumber = inputView.getBonusNumber()
    lotto.validateBonusNumber(bonusNumber)
    lotto.validateBonusWinningUnique(bonusNumber)
    return bonusNumber
}

private fun numberOfTickets(purchaseAmount: Int): Int {
    return purchaseAmount / 1000
}

private fun singleTicketGenerator(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}

fun ticketsGenerator(ticketNum: Int): List<List<Int>> {
    val tickets = mutableListOf<List<Int>>()

    repeat (ticketNum) {
        val ticket =  singleTicketGenerator()
        tickets.add(ticket)
    }
    return tickets
}