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
        val purchasedLottos = buyLottos()
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        calculateMatchedNumbers(purchasedLottos, winningNumbers, bonusNumber)
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

    fun calculateMatchedNumbers(purchasedLottos: List<PurchasedLotto>, winningNumbers: Lotto, bonusNumber: Int) {
        for (lotto in purchasedLottos) {
            val matchCount = lotto.countMatchedNumbersWithWinningNumbers(winningNumbers)
            val isMatchedBonusNumber = lotto.isMatchedWithBonusNumber(bonusNumber)

        }
    }
}