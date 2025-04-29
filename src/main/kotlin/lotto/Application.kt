package lotto

import lotto.controller.LottoController
import lotto.model.LottoTicketMachine
import lotto.model.RandomLottoTicketMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
    val lottoController = LottoController(inputView, outputView, lottoTicketMachine)
    lottoController.start()
}
