package lotto

import lotto.controller.LottoController
import lotto.exception.ApplicationException

fun main() {
    try {
        LottoController().run()
    } catch (e: ApplicationException) {
        println(e.message)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
