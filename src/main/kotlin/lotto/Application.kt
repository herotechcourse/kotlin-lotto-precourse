package lotto

import lotto.engine.LottoEngine

/**
 * Entry point of the Lotto application.
 */
fun main() {
    try {
        val engine = LottoEngine()

        engine.run()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

