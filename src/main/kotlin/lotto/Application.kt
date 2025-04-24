package lotto

import lotto.controller.Controller

fun main() {
    val controller = Controller(LottoStore(RandomLottoMachine))
    controller.run()
}

