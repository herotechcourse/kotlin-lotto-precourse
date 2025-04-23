package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val amount = inputView.inputAmount()
    val tickets = LottoTickets.generate(amount)
    outputView.printTickets(tickets)

    val winningNumbers = inputView.inputWinningNumbers()
    val bonusNumber = inputView.inputBonusNumber(winningNumbers)
}
