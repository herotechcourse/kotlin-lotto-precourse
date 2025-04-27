package lotto.view

import lotto.Lotto

object OutputView {

    fun printPurchasedTickets(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }
}
