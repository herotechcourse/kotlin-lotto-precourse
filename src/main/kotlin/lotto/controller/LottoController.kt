package lotto.controller

import lotto.Lotto
import lotto.domain.PurchasedLotto
import lotto.domain.WinningStatics
import lotto.service.PurchasedLottoService
import lotto.util.*

class LottoController {
    val purchasedLottoService = PurchasedLottoService()
    val winningStatics = WinningStatics()

    fun startLottoDraw() {
        val purchasedLottos = buyLottos()
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        calculateMatchedNumbers(purchasedLottos, winningNumbers, bonusNumber)
    }

    fun buyLottos(): List<PurchasedLotto> {
        val purchasedAmount = getPurchasedAmount() / 1000
        printUserPurchasedTicketPhrase(purchasedAmount)
        purchasedLottoService.generatePurchasedLottoNumbers(purchasedAmount)
        val purchasedLottos = purchasedLottoService.getAllPurchasedLottoNumbers()
        printAllPurchasedLottoNumbers(purchasedLottos)
        return  purchasedLottos
    }

    fun getPurchasedAmount(): Int {
        try {
            val purchasedAmount = inputPurchasedAmount()
            return purchasedAmount
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getPurchasedAmount()
        }
    }

    fun getWinningNumbers(): Lotto {
        try {
            return inputUserWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getWinningNumbers()
        }

    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        try {
            return inputUserBonusNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getBonusNumber(winningNumbers)
        }
    }

    fun calculateMatchedNumbers(purchasedLottos: List<PurchasedLotto>, winningNumbers: Lotto, bonusNumber: Int) {
        printWinningStatisticsPhrase()
        for (lotto in purchasedLottos) {
            val matchCount = lotto.countMatchedNumbersWithWinningNumbers(winningNumbers)
            val isMatchedBonusNumber = lotto.isMatchedWithBonusNumber(bonusNumber)
            makeWinningStatics(matchCount, isMatchedBonusNumber)
        }
        val rateOfReturn = makeRateOfReturn(purchasedLottos.size)
        printWinningStatics(winningStatics.getStatics(), rateOfReturn)
    }

    fun makeWinningStatics(matchCount: Int, isMatchedBonusNumber: Boolean) {
        winningStatics.updateWinningStatics(matchCount, isMatchedBonusNumber)
    }

    fun makeRateOfReturn(purchasedAmount: Int): String {
        val totalPrize = winningStatics.getTotalPrize()
        val rate = (totalPrize.toDouble() / (purchasedAmount * 1000)) * 100
        return String.format("%.1f", rate)
    }
}