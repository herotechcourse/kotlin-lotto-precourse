package lotto

import utils.*

fun main() {
    // TODO: Implement the program
    var amount = InputView.getAmount()
    val purchase = Purchase.make(amount)
    purchase.displayPurchase()
    var winningLotto = InputView.getWinningNumbers()
    var bonusNumber = InputView.getBonusNumber(winningLotto.getNumber())
    val lottoComparator = LottoComparator()
    lottoComparator.compare(purchase, winningLotto,bonusNumber)
    var result = lottoComparator.getResult()
    OutputView.displayResult(result)
    var profit = Accountant.analyse(result, amount)
    OutputView.displayReturnRate(profit)

}
