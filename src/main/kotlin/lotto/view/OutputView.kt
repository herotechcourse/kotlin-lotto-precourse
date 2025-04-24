package lotto.view

import lotto.Lotto

class OutputView {
    fun printUserLottos(userLottos: List<Lotto>) {
        println("You have purchased %d tickets.".format(userLottos.size))
        userLottos.forEach { userLotto ->
            println(userLotto.numbers.sorted())
        }
    }
}
