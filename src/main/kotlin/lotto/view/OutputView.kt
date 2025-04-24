package lotto.view

import lotto.Lotto

object OutputView {
    fun printLottery(lottery: List<Lotto>) {
        lottery.forEach { println(it) }
    }
}