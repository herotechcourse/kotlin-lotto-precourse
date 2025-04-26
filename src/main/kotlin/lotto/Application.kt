package lotto

import lotto.controller.LottoController
import lotto.lottogenerator.RandomLottoGenerator

fun main() {
    val lottoController = LottoController(RandomLottoGenerator())
    lottoController.run()
}
