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
    for(set in result){
        println("${set.key.displayPrize()}"+" – ${set.value} tickets")
    }
    var profit = Accountant.analyse(result, amount)
    println("Total return rate is ${profit}%.")
}
