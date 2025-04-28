package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoMachine

fun main() {
    val lottoMachineService = LottoMachine()
    val controller = LottoGame(lottoMachineService)
    controller.run()
}
