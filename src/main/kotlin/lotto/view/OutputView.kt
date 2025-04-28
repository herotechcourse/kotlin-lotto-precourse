package lotto.view

import lotto.domain.Lottos

object OutputView {
    private const val ERROR_HEAD = "[ERROR]"
    private const val GENERATED_LOTTO_HEADER = "You have purchased %d tickets."

    fun printError(message: String) {
        println("$ERROR_HEAD $message")
    }

    fun printGeneratedLottos(lottos: Lottos) {
        println("\n${GENERATED_LOTTO_HEADER.format(lottos.tickets.size)}")

        lottos.tickets.forEach {
            println(it.formatForDisplay())
        }
    }
}