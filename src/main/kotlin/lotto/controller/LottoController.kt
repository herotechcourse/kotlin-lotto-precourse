package lotto.controller

import lotto.domain.RandomLottos
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoService: LottoService
) {
    fun run() {
        //required user input
        // 1. purchaseAmount, winningNumbers, bonus number
        val randomLotteryTickets = purchaseLotteryTickets()
    }

    //re-enter
    private fun purchaseLotteryTickets(): RandomLottos {
        val purchaseAmount = inputView.askPurchaseAmount()
        val purchaseLotto = lottoService.createRandomLotto(purchaseAmount)
        displayPurchaseTickets(purchaseLotto)

        return purchaseLotto
    }

    private fun displayPurchaseTickets(randomLotto: RandomLottos) {
        val purchasedLottoDto = lottoService.createPurchasedDto(randomLotto)
        outputView.printPurchasedLotto(purchasedLottoDto)
    }
}