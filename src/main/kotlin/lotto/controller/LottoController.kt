package lotto.controller

import lotto.domain.PurchaseAmount
import lotto.domain.prize.PrizeResult
import lotto.domain.winning.BonusNumber
import lotto.domain.winning.RandomLottos
import lotto.domain.winning.WinningNumbers
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoService: LottoService
) {
    fun run() {
        val purchaseAmount = askPurchaseAmount()
        val randomLotteryTickets = purchaseLotteryTickets(purchaseAmount)
        val prizeResult = playAndCalculate(randomLotteryTickets)

        printStatistics(purchaseAmount, prizeResult)
    }

    private fun askPurchaseAmount(): PurchaseAmount {
        return RePromptHandler.run {
            val purchaseAmount = inputView.askPurchaseAmount()
            PurchaseAmount(purchaseAmount)
        }
    }

    private fun purchaseLotteryTickets(purchaseAmount: PurchaseAmount): RandomLottos {
        val purchaseLotto = lottoService.createRandomLotto(purchaseAmount)
        displayPurchaseTickets(purchaseLotto)

        return purchaseLotto
    }

    private fun displayPurchaseTickets(randomLotto: RandomLottos) {
        val purchasedLottoDto = lottoService.createPurchasedDto(randomLotto)
        outputView.printPurchasedLotto(purchasedLottoDto)
    }

    private fun playAndCalculate(randomLotteryTickets: RandomLottos): PrizeResult {
        val winningNumbers = winningNumbers()
        val bonusNumber = bonusNumber(winningNumbers)
        val prizeResult = lottoService.calculatePrizeStatistics(randomLotteryTickets, winningNumbers, bonusNumber)

        return prizeResult
    }

    private fun winningNumbers(): WinningNumbers {
        return RePromptHandler.run {
            val numbersInput = inputView.askWinningNumbers()
            WinningNumbers.from(numbersInput)
        }
    }

    private fun bonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        return RePromptHandler.run {
            val numberInput = inputView.askBonusNumber()
            BonusNumber.from(numberInput, winningNumbers)
        }
    }

    private fun printStatistics(purchaseAmount: PurchaseAmount, prizeResult: PrizeResult) {
        val finalStatisticsDto = lottoService.createStatisticsDto(purchaseAmount, prizeResult)
        outputView.printStatistics(finalStatisticsDto)
    }
}