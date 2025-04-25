package lotto

fun main() {

    val lottoService = LottoService()
    val inputView = InputView()
    val outputView = OutputView()
    val purchaseAmount = inputView.readPurchaseAmount()
    lottoService.purchaseTickets(purchaseAmount)
    outputView.displayPurchasedTickets(lottoService.getTickets())
    inputView.readWinnerNumbers()
}
