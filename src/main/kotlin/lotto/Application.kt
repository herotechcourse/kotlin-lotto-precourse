package lotto

import lotto.OutputView.printTickets

fun main() {
    try {
        val amount = getValidAmount()

        val (winningNumbers, bonus) = getValidWinningNumbers()

        val machine = Lotto(winningNumbers)
        val tickets = machine.purchaseTickets(amount)

        printTickets(tickets)

        val results = machine.calculateResults(tickets, bonus)
        OutputView.printResults(results, amount)
    } catch (e: IllegalArgumentException) {
        println("[ERROR]: ${e.message}")
    }
}

private fun getValidAmount(): Int {
    val amount = InputView.readAmount()
    LotteryValidator.validateAmount(amount)
    return amount
}

private fun getValidWinningNumbers(): Pair<List<Int>, Int> {
    val numbers = InputView.readWinningNumbers()
    val bonus = InputView.readBonusNumber()

    LotteryValidator.validateWinningNumbers(numbers)
    LotteryValidator.validateBonusNumber(bonus, numbers)

    return numbers to bonus
}