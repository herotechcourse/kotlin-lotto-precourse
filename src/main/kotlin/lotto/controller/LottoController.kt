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
        val purchasedLotto = buyLottos()
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
    }

    fun getPurchasedAmount(): Int {
        val purchasedAmount = inputPurchasedAmount()
        return purchasedAmount
    }

    fun buyLottos(): List<PurchasedLotto> {
        val purchasedAmount = getPurchasedAmount() / 1000
        printUserPurchasedTicketPhrase(purchasedAmount)
        purchasedLottoService.generatePurchasedLottoNumbers(purchasedAmount)
        val purchasedLottos = purchasedLottoService.getAllPurchasedLottoNumbers()
        printAllPurchasedLottoNumbers(purchasedLottos)
        return  purchasedLottos
    }

    fun getWinningNumbers(): Lotto {
        return inputUserWinningNumbers()
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        return inputUserBonusNumber(winningNumbers)
    }
}