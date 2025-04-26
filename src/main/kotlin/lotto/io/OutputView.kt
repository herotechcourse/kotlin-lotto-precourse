package lotto.io

import lotto.Lotto
import lotto.LottoResultType
import lotto.LottoResultType.*

object OutputView {

    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        for (lotto in lottos) {
            println(lotto)
        }
        println()
    }

}