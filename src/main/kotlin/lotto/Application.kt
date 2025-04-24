package lotto
import lotto.views.InputView


fun main() {
    val inputView = InputView()
    val tickets = generateLottoTickets()
    val numbers = inputView.inputWinningNumber()
    val luckyNumber = inputView.inputSingleNumber(numbers)
    println("You have purchased ${tickets.count()} tickets.")
    tickets.forEach { println(it) }
    val results = checkWinningTickets(tickets, numbers, luckyNumber)
    val resultCounts = calculateResultCounts(results)
    displayResults(resultCounts)
    displayTotalPrize(resultCounts, tickets.count())
}