package lotto

import lotto.config.LottoConfig
import lotto.controller.LottoController

fun main() {
    val config = LottoConfig()
    val controller = LottoController(config)
    controller.run()
}

