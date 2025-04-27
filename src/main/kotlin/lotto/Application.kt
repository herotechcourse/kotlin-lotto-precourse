package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.LottoGenerator

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    validatePurchaseAmount(purchaseAmount)

    val ticketCount = purchaseAmount / 1000
    val lottos = LottoGenerator.generateLottos(ticketCount)

    OutputView.printPurchasedTickets(lottos)


    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    println(" last week's winning numbers.: $winningNumbers")
    println("the bonus number.: $bonusNumber")
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}
