package lotto

import lotto.view.InputView
import lotto.service.LottoService
import lotto.exception.LottoInputException

fun <T> retryInputUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: LottoInputException) {
            println(e.message);
        }
    }
}

fun main() {
    val amount: Int =
        retryInputUntilSuccess { InputView.getPurchaseAmount().also { LottoService.validatePurchaseAmount(it) } }
    val tickets: List<Lotto> = LottoService.generateTickets(amount)
}