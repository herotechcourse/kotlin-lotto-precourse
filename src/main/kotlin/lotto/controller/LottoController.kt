package lotto.controller

import lotto.Lotto
import lotto.domain.PurchasedLotto
import lotto.repository.PurchasedLottoRepository
import lotto.service.PurchasedLottoService
import lotto.util.*

class LottoController {
    val purchasedLottoRepository = PurchasedLottoRepository()
    val purchasedLottoService = PurchasedLottoService()

    fun startLottoDraw() {
        val purchasedAmount = getPurchasedAmount() / 1000
        buyLottos(purchasedAmount)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
    }

    fun getPurchasedAmount(): Int {
        val purchasedAmount = inputPurchasedAmount()
        return purchasedAmount
    }

    fun buyLottos(ticketCount: Int) {
        printUserPurchasedTicketPhrase(ticketCount)
        purchasedLottoService.generatePurchasedLottoNumbers(ticketCount)
        val purchasedLottos = purchasedLottoService.getAllPurchasedLottoNumbers()
        printAllPurchasedLottoNumbers(purchasedLottos)
    }

    fun getWinningNumbers(): Lotto {
        return inputUserWinningNumbers()
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        return inputUserBonusNumber(winningNumbers)
    }
}